package com.foreign.team.toy.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

@Entity
@Table (name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id" ,nullable = false)
    private Product product;

    @Min(1)
    private int quantity;
    @Column(name = "total_price", precision = 38, scale = 2, nullable = false)
    private BigDecimal totalPrice;

//    //preguntar al cliente si le parece bien este campo
//    @Column(name = "unit_price", nullable = false)
//    private BigDecimal unitePrice;


    public CartItem(Long id, Cart cart, int quantity, Product product, BigDecimal totalPrice) {
        this.id = id;
        this.cart = cart;
        this.quantity = quantity;
        this.product = product;
        this.totalPrice = totalPrice;
    }

    public CartItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
