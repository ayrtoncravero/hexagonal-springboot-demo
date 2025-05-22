package com.hexagonal_test.demo.infrastructure.repository.mysql;

import com.hexagonal_test.demo.domain.model.Product;
import com.hexagonal_test.demo.domain.repository.ProductRepository;
import com.hexagonal_test.demo.infrastructure.entity.ProductEntity;
import com.hexagonal_test.demo.infrastructure.mapper.ProductEntityMapper;
import com.hexagonal_test.demo.infrastructure.repository.SpringDataProductJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MySQLProductRepository implements ProductRepository {
    private final SpringDataProductJpaRepository jpaRepository;

    public MySQLProductRepository(SpringDataProductJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductEntityMapper.toEntity(product);
        ProductEntity saved = jpaRepository.save(entity);

        return ProductEntityMapper.toDomain(saved);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id)
                .map(ProductEntityMapper::toDomain);
    }
}
