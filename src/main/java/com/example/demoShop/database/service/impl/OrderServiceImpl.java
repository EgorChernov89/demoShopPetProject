package com.example.demoShop.database.service.impl;

import com.example.demoShop.database.entity.Order;
import com.example.demoShop.database.repository.OrderRepository;
import com.example.demoShop.database.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Заказ под ID: %d не был найден".formatted(id)));
    }
    public Order createNewOrder (Order newOrder){
        return orderRepository.save(newOrder);
    }
    public Order updateOrder(Long id, Order updatedrder){
        Order exstingOrder = findOrderById(id);
        exstingOrder.setOrderStatus(updatedrder.getOrderStatus());
        exstingOrder.setOrderDate(updatedrder.getOrderDate());
        exstingOrder.setCustomerAddress(updatedrder.getCustomerAddress());
        exstingOrder.setCustomerPhone(updatedrder.getCustomerPhone());
        exstingOrder.setCustomerName(updatedrder.getCustomerName());
        exstingOrder.setCustomerEmail(updatedrder.getCustomerEmail());
        exstingOrder.setTotalPrice(updatedrder.getTotalPrice());
        exstingOrder.setOrderItem(updatedrder.getOrderItem());
        return orderRepository.save(exstingOrder);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
