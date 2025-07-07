package com.foreign.team.toy.store.dto;

import java.math.BigDecimal;
import java.util.List;

public record CartResponse(Long id,
                           Long userId,
                           BigDecimal totalPrice, // El precio total del carrito
                           List<CartItemResponse> items ) // La lista de ítems en el carrito
{
}
