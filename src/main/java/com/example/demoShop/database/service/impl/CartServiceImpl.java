package com.example.demoShop.database.service.impl;


import com.example.demoShop.database.entity.Cart;
import com.example.demoShop.database.entity.CartItem;
import com.example.demoShop.database.entity.Product;
import com.example.demoShop.database.entity.User;
import com.example.demoShop.database.entity.dto.cartDTO.CartDTO;
import com.example.demoShop.database.repository.CartItemRepository;
import com.example.demoShop.database.repository.CartRepository;
import com.example.demoShop.database.service.CartService;
import com.example.demoShop.database.service.ProductService;
import com.example.demoShop.database.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

    private final ProductService productService;

    private final UserService userService;

    private final ModelMapper modelMapper;

    public Cart getOrCreateCart(Long userId) {
        log.info("Поиск корзины у пользователя с ID: {}",userId);
        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    log.info("Создание новой корзины у пользователя с ID: {}",userId);
                    Cart newCart = new Cart();
                    newCart.setUser(userService.findUserById(userId));
                    return cartRepository.save(newCart);
                });
        return cart;
    }
    public CartDTO getCartDTO(Cart cart){
        return modelMapper.map(cart,CartDTO.class);
    }


    public Cart addItemToCart(Long userId, Long productId, Integer quantity) {
        Cart cart = getOrCreateCart(userId);
        log.info("Поиск товара с ID: {}",productId);
        Product prod = productService.findByProductId(productId);

        if (!productService.isAvailable(productId, quantity)) {
            log.warn("Не достаточно товара с ID: {}",productId);
            throw new RuntimeException();
            //TODO сделать исключение свое
        }
        log.info("Фильтрация и поиск по товару с ID: {}, компонента корзины ",productId);
        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().equals(prod))
                .findFirst()
                .orElse(null);
        if (cartItem != null) {
            updateCartItem(cartItem,quantity);
            updateCartTotalPrice(cart);
            prod.setQuantity(prod.getQuantity()-quantity);
        } else {
            createNewCartItem(cart,prod,quantity);
            updateCartTotalPrice(cart);
            prod.setQuantity(prod.getQuantity()-quantity);
        }

        return cartRepository.save(cart);

    }
    private void createNewCartItem(Cart cart,Product product,Integer quantity){
        log.info("Создание компонента корзины");
        CartItem createdCartItem = new CartItem();
        createdCartItem.setProduct(product);
        createdCartItem.setQuantity(quantity);
        createdCartItem.setPrice(product.getPrice());
        createdCartItem.setTotalPrice(product.getPrice() * quantity);
        createdCartItem.setCart(cart);
        cart.getCartItems().add(createdCartItem);
    }
    private void updateCartItem(CartItem cartItem,Integer quantity){
        log.info("Обновление компонента корзины");
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        cartItem.setTotalPrice(cartItem.getPrice()*cartItem.getQuantity());
    }
    private void updateCartTotalPrice(Cart cart){
        log.info("Обновление общей стоимости корзины");
        cart.setTotalPrice(cart.getCartItems().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum());
    }

    public void clearCart(Long userId) {
        log.info("Очистка корзины у пользователя с ID: {}",userId);
        Cart cart = getOrCreateCart(userId);
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }
    public void deleteSelectedCartItem(Long userId,Long productId){
        log.info("Удаление компонента корзины у пользователя с ID: {}",userId);
        Cart cart = getOrCreateCart(userId);
        Product deletedProduct = productService.findByProductId(productId);
        cart.getCartItems().removeIf(item -> item.getProduct().equals(deletedProduct));
        cartRepository.save(cart);
    }

    public List<CartItem> getAllCartItems(Long userId){
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(() -> new EntityNotFoundException("Корзина заказов с ID: %d не найден".formatted(userId)));
        return cartItemRepository.findByCartId(cart.getId());
    }
}
