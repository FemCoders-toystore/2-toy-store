package com.foreign.team.toy.store.controller;

import com.foreign.team.toy.store.exceptions.ResourceConflictException;
import com.foreign.team.toy.store.exceptions.ResourceNotFoundException;
import com.foreign.team.toy.store.model.Product;
import com.foreign.team.toy.store.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) throws ResourceNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody @Valid Product product) throws ResourceConflictException {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody @Valid Product product) throws ResourceNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws ResourceNotFoundException {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
