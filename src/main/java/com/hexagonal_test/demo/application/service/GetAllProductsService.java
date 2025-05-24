package com.hexagonal_test.demo.application.service;

import com.hexagonal_test.demo.application.query.GetAllProductsQuery;
import com.hexagonal_test.demo.domain.model.Product;
import com.hexagonal_test.demo.domain.repository.ProductRepository;
import com.hexagonal_test.demo.domain.service.GetAllProductsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsService implements GetAllProductsUseCase {
    private final ProductRepository productRepository;

    public GetAllProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> handle(GetAllProductsQuery query) {
        return productRepository.findAll();
    }
}
