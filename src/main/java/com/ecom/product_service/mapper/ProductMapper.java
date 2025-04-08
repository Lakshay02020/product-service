package com.ecom.product_service.mapper;

import com.ecom.product_service.dto.ProductDto;
import com.ecom.product_service.entity.Product;

public class ProductMapper {
    // Create new entity from DTO
    public static Product toEntity(ProductDto dto) {
        Product product = new Product();

        if (dto.getName() != null) product.setName(dto.getName());
        if (dto.getBrand() != null) product.setBrand(dto.getBrand());
        if (dto.getCategory() != null) product.setCategory(dto.getCategory());
        if (dto.getPrice() != null) product.setPrice(dto.getPrice());
        if (dto.getSize() != null) product.setSize(dto.getSize());
        if (dto.getColor() != null) product.setColor(dto.getColor());
        if (dto.getImageUrl() != null) product.setImageUrl(dto.getImageUrl());
        if (dto.getDescription() != null) product.setDescription(dto.getDescription());
        if (dto.getQuantityInStock() != null) product.setQuantityInStock(dto.getQuantityInStock());

        product.setIsActive(true);
        product.setCreatedBy("system-user");
        product.setUpdatedBy("system-user");

        return product;
    }

    // Convert entity to DTO
    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .brand(product.getBrand())
                .category(product.getCategory())
                .price(product.getPrice())
                .size(product.getSize())
                .color(product.getColor())
                .imageUrl(product.getImageUrl())
                .description(product.getDescription())
                .quantityInStock(product.getQuantityInStock())
                .build();
    }

    // Update existing entity from DTO
    public static void updateEntity(Product existing, ProductDto dto) {
        if (dto.getName() != null) existing.setName(dto.getName());
        if (dto.getBrand() != null) existing.setBrand(dto.getBrand());
        if (dto.getCategory() != null) existing.setCategory(dto.getCategory());
        if (dto.getPrice() != null) existing.setPrice(dto.getPrice());
        if (dto.getSize() != null) existing.setSize(dto.getSize());
        if (dto.getColor() != null) existing.setColor(dto.getColor());
        if (dto.getImageUrl() != null) existing.setImageUrl(dto.getImageUrl());
        if (dto.getDescription() != null) existing.setDescription(dto.getDescription());
        if (dto.getQuantityInStock() != null) existing.setQuantityInStock(dto.getQuantityInStock());

        existing.setUpdatedBy("system-user");
    }
}
