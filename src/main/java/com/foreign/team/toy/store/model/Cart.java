/**
 * This entity acts as a snapshot of the user's shopping cart state in the database.
 *
 * In this project, the Cart does not handle business logic directly (e.g., adding or removing items)
 * because we do not have a frontend that manages a dynamic cart in real time.
 *
 * Instead, CartItemService is responsible for adding, removing, and updating CartItems,
 * as well as updating the total price of the Cart.
 *
 * This design keeps Cart as a simple container and ensures business logic is centralized
 * in the service layer, following the KISS and SRP principles.
 */
package com.foreign.team.toy.store.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice = BigDecimal.ZERO;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    public Cart(){}

    public Long getId(){
        return  id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}