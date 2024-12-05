package com.example.demoShop.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Представляет товар, который доступен для покупки в интернет-магазине
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameProduct")
    private String nameProduct;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToMany(mappedBy = "products")
    private List<Category> category;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItem;
}
