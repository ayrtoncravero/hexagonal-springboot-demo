package com.hexagonal_test.demo.infrastructure.mapper;

import com.hexagonal_test.demo.domain.model.Product;
import com.hexagonal_test.demo.infrastructure.entity.ProductEntity;

public class ProductEntityMapper {
    public static ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();

        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());

        return entity;
    }

    public static Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice()
        );
    }
}
