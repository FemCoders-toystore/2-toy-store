package com.foreign.team.toy.store.repository;

import com.foreign.team.toy.store.model.Cart;
import com.foreign.team.toy.store.model.CartItem;
import com.foreign.team.toy.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);

    List<CartItem> findByCart(Cart cart);
}
