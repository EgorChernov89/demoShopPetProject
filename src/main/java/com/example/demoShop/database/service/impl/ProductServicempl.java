package com.example.demoShop.database.service.impl;

import com.example.demoShop.database.entity.Product;
import com.example.demoShop.database.entity.dto.productDTO.ProductCreateDTO;
import com.example.demoShop.database.repository.ProductRepository;
import com.example.demoShop.database.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServicempl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public Product findByProductId(Long id) {
        return productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Продукт с ID: %id не найден".formatted(id)));
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product createNewProduct (ProductCreateDTO productCreateDTO) {
        Product product = modelMapper.map(ProductCreateDTO.class,Product.class);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updateProduct) {
        Product existingProduct = findByProductId(id);
        existingProduct.setNameProduct(updateProduct.getNameProduct());
        existingProduct.setPrice(updateProduct.getPrice());
        existingProduct.setDescription(updateProduct.getDescription());
        existingProduct.setQuantity(updateProduct.getQuantity());
        return productRepository.save(existingProduct);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
