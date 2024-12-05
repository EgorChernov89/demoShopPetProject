package com.example.demoShop.database.repository;

import com.example.demoShop.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
