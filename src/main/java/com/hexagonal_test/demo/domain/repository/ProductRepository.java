package com.hexagonal_test.demo.domain.repository;

import com.hexagonal_test.demo.domain.model.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    Product save(Product product);
}
