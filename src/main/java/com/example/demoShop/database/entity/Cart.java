package com.example.demoShop.database.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Table(name = "cart")
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @Column(name = "total_price_cart")
    private Double totalPrice;
}
