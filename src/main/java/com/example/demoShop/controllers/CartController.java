package com.example.demoShop.controllers;

import com.example.demoShop.database.entity.Cart;
import com.example.demoShop.database.entity.dto.cartDTO.CartDTO;
import com.example.demoShop.database.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addItemToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer quantity) {
        return ResponseEntity.ok(cartService.addItemToCart(userId, productId, quantity));

    }
    @DeleteMapping("/remove")
    public void removeItemFromCart(@RequestParam Long userId,@RequestParam Long productId){
        cartService.deleteSelectedCartItem(userId,productId);
    }
    @DeleteMapping("/clearCart/{userId}")
    public void cleartCart(@PathVariable Long userId){
        cartService.clearCart(userId);
    }

    @GetMapping("/getCart/{userId}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Long userId){
        Cart cart = cartService.getOrCreateCart(userId);
        return ResponseEntity.ok(cartService.getCartDTO(cart));
    }

}
