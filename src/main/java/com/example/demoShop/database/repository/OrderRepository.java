package com.example.demoShop.database.repository;

import com.example.demoShop.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
