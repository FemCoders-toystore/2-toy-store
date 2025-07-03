package com.foreign.team.toy.store.service;

import com.foreign.team.toy.store.model.Cart;
import com.foreign.team.toy.store.model.User;
import com.foreign.team.toy.store.repository.CartRepository;
import com.foreign.team.toy.store.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public CartService(CartRepository cartRepository,UserRepository userRepository ) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public Cart createCart(@NotNull Cart cart) {

        Long userId = cart.getUser().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not founds with ID: " + userId));


        if (cartRepository.findByUserId(userId).isPresent()) {
            throw new RuntimeException("User has a car");
        }


        cart.setUser(user);
        cart.setTotalPrice(cart.getTotalPrice() == null ? java.math.BigDecimal.ZERO : cart.getTotalPrice());

        return cartRepository.save(cart);
    }
}

