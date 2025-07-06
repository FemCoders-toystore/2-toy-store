package com.foreign.team.toy.store.controller;

import com.foreign.team.toy.store.model.Cart;
import com.foreign.team.toy.store.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }
    @PostMapping("/{userId}")
    public ResponseEntity<Cart> createCart(@PathVariable Long userId) {
        Cart createdCart = cartService.createCart(userId);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCart.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdCart);
    }


    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
       Cart cart = cartService.getCartById(cartId);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Long userId) {
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }
}
