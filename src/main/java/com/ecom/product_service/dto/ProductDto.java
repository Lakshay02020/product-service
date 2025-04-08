package com.ecom.product_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private String name;
    private String brand;
    private String category;
    private Double price;
    private String size;
    private String color;
    private String imageUrl;
    private String description;
    private Integer quantityInStock;
}
