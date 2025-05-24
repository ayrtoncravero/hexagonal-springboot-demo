package com.hexagonal_test.demo.domain.service;

import com.hexagonal_test.demo.domain.model.Product;
import com.hexagonal_test.demo.infrastructure.dto.request.UpdateProductRequest;

import java.util.Optional;

public interface UpdateOneByIdUseCase {
    Optional<Product> handle(Long id, UpdateProductRequest dto);
}
