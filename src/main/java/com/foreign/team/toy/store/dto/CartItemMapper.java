package com.foreign.team.toy.store.dto;

import com.foreign.team.toy.store.model.CartItem;

public class CartItemMapper {

    public static CartItem toEntity(CartItemRequest req) {
        CartItem cartItem = new CartItem();
        // Seteamos solo los datos del request, las relaciones deben manejarse en el Service
        cartItem.setQuantity(req.quantity());
        // Para cart y product, normalmente se setean con entidades recuperadas en el Service
        // Así que aquí no las seteamos para no crear inconsistencias.
        return cartItem;
    }

    public static CartItemResponse toCartItemResponse(CartItem cartItem) {
        return new CartItemResponse(
                cartItem.getId(),
                cartItem.getProduct() != null ? cartItem.getProduct().getId() : null,
                cartItem.getProduct() != null ? cartItem.getProduct().getName() : null,
                cartItem.getQuantity(),
                cartItem.getTotalPrice()
        );
    }

}
