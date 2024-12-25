package com.example.demoShop.database.entity.dto.cartItemDTO;


import com.example.demoShop.database.entity.Cart;
import com.example.demoShop.database.entity.Product;
import com.example.demoShop.database.entity.dto.productDTO.ProductForCartDTO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {

//    private Cart cart;

    private ProductForCartDTO product;

    private Integer quantity;

    private Double price;

    private Double totalPrice;

}
