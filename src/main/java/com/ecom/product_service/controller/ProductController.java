package com.ecom.product_service.controller;

import com.ecom.product_service.dto.ProductDto;
import com.ecom.product_service.entity.Product;
import com.ecom.product_service.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    // 1. Get by Product ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        log.info("Fetching product with ID: {}", id);
        Product product = productService.getById(id);
        log.debug("Fetched product: {}", product);
        return ResponseEntity.ok(product);
    }

    // 2. Add Product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto) {
        log.info("Adding new product: {}", productDto);
        Product created = productService.addProduct(productDto);
        log.debug("Created product: {}", created);
        return ResponseEntity.ok(created);
    }

    // 3. Update Product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        log.info("Updating product with ID: {}, New values: {}", id, productDto);
        Product updated = productService.updateProduct(id, productDto);
        log.debug("Updated product: {}", updated);
        return ResponseEntity.ok(updated);
    }

    // 4. Delete Product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        log.info("Deleting product with ID: {}", id);
        productService.deleteProduct(id);
        log.info("Product deleted with ID: {}", id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    // 5. Get All Products with pagination
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("Fetching all products - Page: {}, Size: {}", page, size);
        List<ProductDto> products = productService.getAllProducts(page,size);
        return ResponseEntity.ok(products);
    }
}
