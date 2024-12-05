package com.example.demoShop.database.service;

import com.example.demoShop.database.entity.Order;

import java.util.List;

public interface OrderService {
    Order findOrderById(Long id);

    Order createNewOrder(Order newOrder);

    Order updateOrder(Long id, Order updatedrder);

    List<Order> findAll();

    void deleteOrder(Long id);

}
