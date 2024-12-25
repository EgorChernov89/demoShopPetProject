package com.example.demoShop.database.repository;

import com.example.demoShop.database.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    void deleteByCartId(Long id);

    List<CartItem> findByCartId(Long id);
}
