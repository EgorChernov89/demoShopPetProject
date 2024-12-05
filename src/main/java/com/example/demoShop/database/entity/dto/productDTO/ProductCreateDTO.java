package com.example.demoShop.database.entity.dto.productDTO;

import com.example.demoShop.database.entity.Category;
import com.example.demoShop.database.entity.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductCreateDTO {

    private String nameProduct;

    private BigDecimal price;

    private Integer quantity;

    private String description;


}
