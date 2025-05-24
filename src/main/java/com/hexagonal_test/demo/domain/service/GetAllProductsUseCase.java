package com.hexagonal_test.demo.domain.service;

import com.hexagonal_test.demo.application.query.GetAllProductsQuery;
import com.hexagonal_test.demo.domain.model.Product;

import java.util.List;

public interface GetAllProductsUseCase {
    List<Product> handle(GetAllProductsQuery query);
}
