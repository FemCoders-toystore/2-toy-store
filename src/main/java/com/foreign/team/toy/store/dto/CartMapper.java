package com.foreign.team.toy.store.dto;
import com.foreign.team.toy.store.dto.CartItemMapper;
import com.foreign.team.toy.store.dto.CartItemResponse;
import com.foreign.team.toy.store.model.Cart;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {
    public static Cart toEntity(CartRequest cartRequest) {
        Cart cart = new Cart();
        // Lógica para mapear CartRequest a Cart, sin relaciones complejas aquí
        return cart;
    }

    public static CartResponse toResponse(Cart cart) {
        List<CartItemResponse> items = (cart.getItems() != null)
                ? cart.getItems().stream()
                // Aquí llamas al mapper de CartItem para cada ítem
                .map(CartItemMapper::toCartItemResponse)
                .collect(Collectors.toList())
                : Collections.emptyList();

        return new CartResponse(
                cart.getId(),
                cart.getUser() != null ? cart.getUser().getId() : null,
                cart.getTotalPrice(),
                items
        );
    }
}
