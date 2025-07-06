package com.foreign.team.toy.store.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CartItemRequest(
        @NotNull(message = "Cart ID is required")
        Long cartId,

        @NotNull(message = "Product ID is required")
        Long productId,

        @NotNull(message = "Quantity is required")
        @Min(value = 1, message = "Quantity must be at least 1")
        Integer quantity
) {}
