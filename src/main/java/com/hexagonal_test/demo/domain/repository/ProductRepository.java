package com.hexagonal_test.demo.domain.repository;

import com.hexagonal_test.demo.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> getOneById(Long id);
    void deleteById(Long id);
}
