package com.ecom.product_service.service.impl;

import com.ecom.product_service.dto.ProductDto;
import com.ecom.product_service.entity.Product;
import com.ecom.product_service.mapper.ProductMapper;
import com.ecom.product_service.repository.ProductRepository;
import com.ecom.product_service.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // GET by ID
    @Override
    public Product getById(Long id) {
        log.info("Getting product by ID: {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // ADD Product
    @Override
    public Product addProduct(ProductDto productDto) {
        log.info("Adding new product: {}", productDto.getName());
        Product product = ProductMapper.toEntity(productDto);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, ProductDto productDto) {
        log.info("Updating product with ID: {}", id);
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        ProductMapper.updateEntity(existing, productDto);

        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("Deleting product with ID: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        productRepository.delete(product);
        log.info("Product deleted successfully: {}", id);
    }

    @Override
    public List<ProductDto> getAllProducts(int page, int size) {
        log.info("Fetching all products - page: {}, size: {}", page, size);

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);

        return products.getContent()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

}
