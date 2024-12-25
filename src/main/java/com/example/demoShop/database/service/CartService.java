package com.example.demoShop.database.service;

import com.example.demoShop.database.entity.Cart;
import com.example.demoShop.database.entity.CartItem;
import com.example.demoShop.database.entity.Product;
import com.example.demoShop.database.entity.User;
import com.example.demoShop.database.entity.dto.cartDTO.CartDTO;

import java.util.List;

public interface CartService {
    Cart getOrCreateCart(Long userId);
    CartDTO getCartDTO(Cart cart);
    void clearCart(Long userId);
    Cart addItemToCart(Long userId, Long productId, Integer quantity);
    void deleteSelectedCartItem(Long userId,Long productId);
    List<CartItem> getAllCartItems(Long userId);





}
