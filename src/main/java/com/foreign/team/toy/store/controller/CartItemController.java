package com.foreign.team.toy.store.controller;

import com.foreign.team.toy.store.model.CartItem;
import com.foreign.team.toy.store.service.CartItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }
    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
        CartItem cartItem = cartItemService.getCartItemById(id);
        return ResponseEntity.ok(cartItem);
    }
    @GetMapping("/cart/{cartId}")
    public List<CartItem> getCartItemsByCartId(@PathVariable Long cartId) {
        return cartItemService.getCartItemsByCartId(cartId);
    }

    @PostMapping
    public ResponseEntity<CartItem> addItemToCart(
            @RequestParam Long cartId,
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        CartItem cartItem = cartItemService.addItemToCart(cartId, productId, quantity);
        return new ResponseEntity<>(cartItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItemQuantity(
            @PathVariable Long id,
            @RequestParam Integer quantity) {

        CartItem updatedCartItem = cartItemService.updateCartItemQuantity(id, quantity);
        return ResponseEntity.ok(updatedCartItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long id) {
        cartItemService.removeCartItem(id);
        return ResponseEntity.noContent().build();
    }
}
