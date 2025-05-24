package com.hexagonal_test.demo.application.service;

import com.hexagonal_test.demo.domain.repository.ProductRepository;
import com.hexagonal_test.demo.domain.service.DeleteOneByIdUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteOneByIdService implements DeleteOneByIdUseCase {
    private final ProductRepository productRepository;

    public DeleteOneByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void handle(Long id) {
        productRepository.getOneById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productRepository.deleteById(id);
    }
}
