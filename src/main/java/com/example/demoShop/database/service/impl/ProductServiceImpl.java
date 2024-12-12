package com.example.demoShop.database.service.impl;

import com.example.demoShop.database.entity.Product;
import com.example.demoShop.database.entity.dto.productDTO.ProductCreateAndUpdateDTO;
import com.example.demoShop.database.repository.ProductRepository;
import com.example.demoShop.database.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    private Product findByProductId(Long id) {
        log.info("Запуск поиска продукта с ID: {}",id);
        Product product = productRepository.findById(id)
                .orElseThrow(() ->{
                    log.warn("Продукт с ID: {} не найден",id);
                return new EntityNotFoundException("Продукт с ID: %id не найден".formatted(id));
                });
        log.info("Завершение поиска продукта {} с ID: {}",product,id);
        return product;
    }


    public ProductCreateAndUpdateDTO findByProductDTOId(Long id) {
        Product product =findByProductId(id);
        return modelMapper.map(product, ProductCreateAndUpdateDTO.class);
    }

    public List<ProductCreateAndUpdateDTO> findAllProducts() {
        log.info("Запуск метода выдачи списка всех продуктов");
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductCreateAndUpdateDTO.class))
                .collect(Collectors.toList());
    }

    public Product createNewProduct(ProductCreateAndUpdateDTO productCreateDTO) {
        log.info("Запуск метода по созданию нового продукта");
        Product product = modelMapper.map(productCreateDTO, Product.class);
        log.info("Успешное создание нового продукта: {}",product);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductCreateAndUpdateDTO updateProduct) {
        log.info("Запуск метода по обновлению продукта");
        Product existingProduct = findByProductId(id);
        updateExistingProduct(existingProduct, updateProduct);
        log.info("Успешное обновление продукта: {}",existingProduct);
        return productRepository.save(existingProduct);
    }

    private void updateExistingProduct(Product updateProduct, ProductCreateAndUpdateDTO productCreateAndUpdateDTO) {
        if (productCreateAndUpdateDTO.getNameProduct() != null) {
            updateProduct.setNameProduct(productCreateAndUpdateDTO.getNameProduct());
        }
        if (productCreateAndUpdateDTO.getNameProduct() != null) {
            updateProduct.setPrice(productCreateAndUpdateDTO.getPrice());
        }
        if (productCreateAndUpdateDTO.getNameProduct() != null) {
            updateProduct.setDescription(productCreateAndUpdateDTO.getDescription());
        }
        if (productCreateAndUpdateDTO.getNameProduct() != null) {
            updateProduct.setQuantity(productCreateAndUpdateDTO.getQuantity());
        }

    }

    public void deleteProduct(Long id) {
        log.info("Запуск метода по удалению устройства с ID: {}",id);
        productRepository.deleteById(id);
    }
}
