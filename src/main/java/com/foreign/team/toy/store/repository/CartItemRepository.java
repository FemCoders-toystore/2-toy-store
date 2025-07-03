package com.foreign.team.toy.store.repository;

import com.foreign.team.toy.store.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
