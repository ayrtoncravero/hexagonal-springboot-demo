package com.hexagonal_test.demo.domain.service;

import com.hexagonal_test.demo.application.command.CreateProductCommand;
import com.hexagonal_test.demo.domain.model.Product;

public interface CreateProductUseCase {
    Product create(CreateProductCommand command);
}
