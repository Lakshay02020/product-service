package com.ecom.product_service.service;

import com.ecom.product_service.dto.ProductDto;
import com.ecom.product_service.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product getById(Long id);

    Product addProduct(ProductDto productDto);

    Product updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);

    List<ProductDto> getAllProducts(int page, int size);
}
