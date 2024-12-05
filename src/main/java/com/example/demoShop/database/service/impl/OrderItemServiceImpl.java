package com.example.demoShop.database.service.impl;


import com.example.demoShop.database.entity.OrderItem;
import com.example.demoShop.database.repository.OrderItemRepository;
import com.example.demoShop.database.repository.OrderRepository;
import com.example.demoShop.database.service.OrderItemService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItem findById(long id) {
        return orderItemRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Компонент заказа с ID: %d не найден".formatted(id)));
    }
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }
    public OrderItem createNewOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
    public OrderItem updateOrderItem(long id, OrderItem updatedOrderItem) {
        OrderItem exstingOrderItem = findById(id);
        exstingOrderItem.setOrder(updatedOrderItem.getOrder());
        exstingOrderItem.setQuantity(updatedOrderItem.getQuantity());
        exstingOrderItem.setPrice(updatedOrderItem.getPrice());
        exstingOrderItem.setProduct(updatedOrderItem.getProduct());
        exstingOrderItem.setTotalPrice(updatedOrderItem.getTotalPrice());
        return orderItemRepository.save(exstingOrderItem);
    }
    public void deleteOrderItem(long id) {
        orderItemRepository.deleteById(id);
    }
}
