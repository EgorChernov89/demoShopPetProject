package com.example.demoShop.database.service;

import com.example.demoShop.database.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem findById(long id);
    List<OrderItem> findAll();
    OrderItem createNewOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(long id, OrderItem updatedOrderItem);
    void deleteOrderItem(long id);
}
