package com.foreign.team.toy.store.dto;

import java.math.BigDecimal;

public record CartItemResponse(
        Long id,
        Long cartId,
        Long productId,
        Integer quantity,
        BigDecimal totalPrice
) {}
