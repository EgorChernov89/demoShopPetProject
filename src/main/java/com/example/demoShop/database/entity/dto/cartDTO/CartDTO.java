package com.example.demoShop.database.entity.dto.cartDTO;

import com.example.demoShop.database.entity.CartItem;
import com.example.demoShop.database.entity.User;
import com.example.demoShop.database.entity.dto.cartItemDTO.CartItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {


//    private User user;

        private List<CartItemDTO> cartItems;
//    private List<CartItem> cartItems;
    private Double totalPrice;
}

