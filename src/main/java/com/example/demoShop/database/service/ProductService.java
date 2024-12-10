package com.example.demoShop.database.service;

import com.example.demoShop.database.entity.Product;
import com.example.demoShop.database.entity.dto.productDTO.ProductCreateAndUpdateDTO;

import java.util.List;

public interface ProductService {
    ProductCreateAndUpdateDTO findByProductDTOId(Long id);

    List<ProductCreateAndUpdateDTO> findAllProducts();

    Product createNewProduct(ProductCreateAndUpdateDTO productCreateDTO);

    Product updateProduct(Long id, ProductCreateAndUpdateDTO updateProductDTO);

    void deleteProduct(Long id);
}