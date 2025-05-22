package com.hexagonal_test.demo.infrastructure.controller;

import com.hexagonal_test.demo.application.command.CreateProductCommand;
import com.hexagonal_test.demo.domain.model.Product;
import com.hexagonal_test.demo.domain.service.CreateProductUseCase;
import com.hexagonal_test.demo.infrastructure.dto.CreateProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final CreateProductUseCase createProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody CreateProductRequest request) {
        CreateProductCommand command = new CreateProductCommand(
                request.getName(),
                request.getPrice(),
                request.getDescription()
        );

        Product product = createProductUseCase.create(command);

        return  ResponseEntity.ok(product);
    }
}
