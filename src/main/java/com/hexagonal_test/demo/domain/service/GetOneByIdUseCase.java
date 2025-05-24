package com.hexagonal_test.demo.domain.service;

import com.hexagonal_test.demo.domain.model.Product;

import java.util.Optional;

public interface GetOneByIdUseCase {
    Optional<Product> handle(Long id);
}
