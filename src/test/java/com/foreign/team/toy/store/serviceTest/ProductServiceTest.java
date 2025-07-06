package com.foreign.team.toy.store.serviceTest;

import com.foreign.team.toy.store.model.Product;
import com.foreign.team.toy.store.repository.ProductRepository;
import com.foreign.team.toy.store.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void testGetAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Doll");
        product1.setPrice(BigDecimal.valueOf(29.99));

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Robot");
        product2.setPrice(BigDecimal.valueOf(49.99));

        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = productService.getAllProducts();

        assertEquals(2, products.size());
        assertEquals("Doll", products.get(0).getName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductById_Found() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Teddy");
        product.setPrice(BigDecimal.valueOf(19.99));

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(1L);
        assertNotNull(result);
        assertEquals("Teddy", result.getName());
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setName("Car");
        product.setPrice(BigDecimal.valueOf(9.99));

        when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.createProduct(product);
        assertNotNull(savedProduct);
        assertEquals("Car", savedProduct.getName());
        verify(productRepository, times(1)).save(product);
    }
}
