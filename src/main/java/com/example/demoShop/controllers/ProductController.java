package com.example.demoShop.controllers;

import com.example.demoShop.database.entity.Product;
import com.example.demoShop.database.entity.dto.productDTO.ProductCreateAndUpdateDTO;
import com.example.demoShop.database.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductCreateAndUpdateDTO>> getAllProducts() {

        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/findProduct/{id}")
    public ResponseEntity<ProductCreateAndUpdateDTO> findProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findByProductDTOId(id));
    }


    @PostMapping("/createNewProduct")
    public ResponseEntity<Product> createProduct(@RequestBody ProductCreateAndUpdateDTO productCreateDTO) {

        return ResponseEntity.ok(productService.createNewProduct(productCreateDTO));
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody ProductCreateAndUpdateDTO productUpdate){

        return ResponseEntity.ok( productService.updateProduct(id,productUpdate));
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
