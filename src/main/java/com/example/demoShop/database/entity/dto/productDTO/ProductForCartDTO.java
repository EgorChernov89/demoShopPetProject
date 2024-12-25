package com.example.demoShop.database.entity.dto.productDTO;

import com.example.demoShop.database.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForCartDTO {

    private String nameProduct;

    private Double price;

    private Integer quantity;

    private String image;

    private List<Category> category;
}
