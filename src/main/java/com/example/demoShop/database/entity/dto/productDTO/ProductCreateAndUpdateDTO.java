package com.example.demoShop.database.entity.dto.productDTO;

import com.example.demoShop.database.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateAndUpdateDTO {

    private String nameProduct;

    private BigDecimal price;

    private Integer quantity;

    private String description;

    private String image;

    private List<Category> category;


}
