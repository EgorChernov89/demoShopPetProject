package com.example.demoShop.database.service;

import com.example.demoShop.database.entity.Product;
import com.example.demoShop.database.entity.dto.productDTO.ProductCreateDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product findByProductId(Long id);

    List<Product> findAllProducts();

    Product createNewProduct(ProductCreateDTO productCreateDTO);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}