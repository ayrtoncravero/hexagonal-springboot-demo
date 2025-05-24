package com.hexagonal_test.demo.application.service;

import com.hexagonal_test.demo.domain.model.Product;
import com.hexagonal_test.demo.domain.repository.ProductRepository;
import com.hexagonal_test.demo.domain.service.UpdateOneByIdUseCase;
import com.hexagonal_test.demo.infrastructure.dto.request.UpdateProductRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateOneByIdService implements UpdateOneByIdUseCase {
    private final ProductRepository productRepository;

    public UpdateOneByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(Long id, UpdateProductRequest dto) {
        Product internalProduct = productRepository.getOneById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Product updatedProduct = new Product(
                internalProduct.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getPrice()
        );

        productRepository.save(updatedProduct);

        return Optional.of(updatedProduct);
    }
}
