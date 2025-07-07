package com.foreign.team.toy.store.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "Product name is required")
        String name,
        @NotNull(message = "Price is required")
        BigDecimal price,
        String imageUrl,
        boolean featured,
        @NotNull(message = "Category ID is required")
        Long categoryId
) {}
