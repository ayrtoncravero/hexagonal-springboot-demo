package com.hexagonal_test.demo.infrastructure.controller;

import com.hexagonal_test.demo.application.command.CreateProductCommand;
import com.hexagonal_test.demo.application.query.GetAllProductsQuery;
import com.hexagonal_test.demo.application.service.DeleteOneByIdService;
import com.hexagonal_test.demo.application.service.GetOneProductByIdService;
import com.hexagonal_test.demo.application.service.UpdateOneByIdService;
import com.hexagonal_test.demo.domain.model.Product;
import com.hexagonal_test.demo.domain.service.CreateProductUseCase;
import com.hexagonal_test.demo.domain.service.GetAllProductsUseCase;
import com.hexagonal_test.demo.infrastructure.dto.request.CreateProductRequest;
import com.hexagonal_test.demo.infrastructure.dto.request.UpdateProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final CreateProductUseCase createProductUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;
    private final GetOneProductByIdService getOneProductByIdService;
    private final UpdateOneByIdService updateOneByIdService;
    private final DeleteOneByIdService deleteOneByIdService;

    public ProductController(
            CreateProductUseCase createProductUseCase,
            GetAllProductsUseCase getAllProductsUseCase,
            GetOneProductByIdService getOneProductByIdService,
            UpdateOneByIdService updateOneByIdService,
            DeleteOneByIdService deleteOneByIdService
    ) {
        this.createProductUseCase = createProductUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
        this.getOneProductByIdService = getOneProductByIdService;
        this.updateOneByIdService = updateOneByIdService;
        this.deleteOneByIdService = deleteOneByIdService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody CreateProductRequest request) {
        CreateProductCommand command = new CreateProductCommand(
                request.getName(),
                request.getPrice(),
                request.getDescription()
        );

        Product product = createProductUseCase.create(command);

        return  ResponseEntity.ok(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return getAllProductsUseCase.handle(new GetAllProductsQuery());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneById(@PathVariable Long id) {
        Optional<Product> product = getOneProductByIdService.handle(id);
        if (product.isEmpty()) {
            log.warn("Producto no encontrado con id: {}", id);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateOne(@PathVariable Long id, @RequestBody UpdateProductRequest dto) {
        try {
            Optional<Product> updatedProduct = updateOneByIdService.handle(id, dto);

            return updatedProduct.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (RuntimeException error) {
            return ResponseEntity.notFound().build();
        }
    }

    // Add delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteOneByIdService.handle(id);

        return ResponseEntity.noContent().build();
    }
}
