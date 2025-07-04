package com.foreign.team.toy.store.service;

import com.foreign.team.toy.store.model.Cart;
import com.foreign.team.toy.store.model.User;
import com.foreign.team.toy.store.repository.CartRepository;
import com.foreign.team.toy.store.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public CartService(CartRepository cartRepository,UserRepository userRepository ) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }
    public Cart createCart(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Optional<Cart> existingCart = cartRepository.findByUserId(userId);
        if (existingCart.isPresent()) {
            throw new RuntimeException("User already has a cart");
        }

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setTotalPrice(BigDecimal.ZERO);

        return cartRepository.save(cart);
    }
    public Cart getCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with ID: " + id));
    }

    public Cart getCartByUserId(Long userId){
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("No cart found for user ID: " + userId));
    }
    public void deleteCart(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Cart not found with ID: " + cartId);
        }
        cartRepository.deleteById(cartId);
    }
}


