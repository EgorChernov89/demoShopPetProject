package com.example.demoShop.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Представляет заказ, созданный пользователем.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @Column(name = "orderStatus")
    private String orderStatus;

    @Column(name = "orderDate")
    private String orderDate;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerPhone")
    private String customerPhone;

    @Column(name = "customerEmail")
    private String customerEmail;

    @Column(name = "customerAddress")
    private String customerAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User users;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItem;


}
