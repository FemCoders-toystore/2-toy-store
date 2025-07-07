package com.foreign.team.toy.store.dto;

import com.foreign.team.toy.store.dto.ProductRequest;
import com.foreign.team.toy.store.dto.ProductResponse;
import com.foreign.team.toy.store.model.Category;
import com.foreign.team.toy.store.model.Product;

public class ProductMapper {
    public static Product dtoToEntity(ProductRequest dto, Category category) {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setImageUrl(dto.imageUrl());
        product.setFeatured(dto.featured());
        product.setCategory(category);
        return product;
    }
    public static ProductResponse entityToDto(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl(),
                product.isFeatured(),
                product.getCategory().getId(),
                product.getCategory().getName()
        );
    }
}
