package com.hexagonal_test.demo.application.service;

import com.hexagonal_test.demo.application.command.CreateProductCommand;
import com.hexagonal_test.demo.domain.model.Product;
import com.hexagonal_test.demo.domain.repository.ProductRepository;
import com.hexagonal_test.demo.domain.service.CreateProductUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements CreateProductUseCase {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(CreateProductCommand command) {
        Product product = new Product(
                null,
                command.getName(),
                command.getDescription(),
                command.getPrice()
        );

        return productRepository.save(product);
    }
}
