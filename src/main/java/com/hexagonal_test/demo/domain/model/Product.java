package com.hexagonal_test.demo.domain.model;

import java.math.BigDecimal;

public class Product {
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;

    public Product(Long id, String name, String description, BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw  new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public  Long getId() { return  id; }
    public  String getName() { return  name; }
    public  String getDescription() { return  description; }
    public  BigDecimal getPrice() { return  price; }
}
