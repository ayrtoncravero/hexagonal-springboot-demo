package com.hexagonal_test.demo.infrastructure.repository;

import com.hexagonal_test.demo.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
