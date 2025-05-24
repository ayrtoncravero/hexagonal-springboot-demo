package com.hexagonal_test.demo.application.service;

import com.hexagonal_test.demo.domain.model.Product;
import com.hexagonal_test.demo.domain.repository.ProductRepository;
import com.hexagonal_test.demo.domain.service.GetOneByIdUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOneProductByIdService implements GetOneByIdUseCase {
    private final ProductRepository productRepository;

    public GetOneProductByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(Long id) {
        return productRepository.getOneById(id);
    }
}
