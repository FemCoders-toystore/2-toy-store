package com.foreign.team.toy.store.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        String imageUrl,
        boolean featured,
        Long categoryId,
        String categoryName
) {
}
