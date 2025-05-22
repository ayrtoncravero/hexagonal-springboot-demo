package com.hexagonal_test.demo.application.command;

import java.math.BigDecimal;

public class CreateProductCommand {
    private final String name;
    private final BigDecimal price;
    private final String description;

    public CreateProductCommand(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
