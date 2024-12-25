package com.example.demoShop.database.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER
//            ,cascade = CascadeType.ALL
    )
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity_cartItem")
    private Integer quantity;

    @Column(name = "price_cartItem")
    private Double price;

    @Column(name = "total_price_cartItem")
    private Double totalPrice;

}
