package com.example.demoShop.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Классификация продуктов по категориям, чтобы облегчить пользователям поиск товаров по типу.
 *
 */
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "nameCategory")
    private String nameCategory;

    @Column(name = "descriptionCategory")
    private String descriptionCategory;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "categories_orders",
    joinColumns = @JoinColumn(name = "category_id"),
    inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products;

}
