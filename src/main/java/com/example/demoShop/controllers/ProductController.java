package com.example.demoShop.controllers;

import com.example.demoShop.database.entity.Product;
import com.example.demoShop.database.entity.dto.productDTO.ProductCreateDTO;
import com.example.demoShop.database.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;
@PostMapping("/")
    public ResponseEntity<ProductCreateDTO> createProduct(ProductCreateDTO productCreateDTO) {
        Product product = modelMapper.map(ProductCreateDTO.class,Product.class);
        return null;
    }


}
