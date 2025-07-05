package com.foreign.team.toy.store.service;

import com.foreign.team.toy.store.exceptions.ResourceNotFoundException;
import com.foreign.team.toy.store.model.Cart;
import com.foreign.team.toy.store.model.CartItem;
import com.foreign.team.toy.store.model.Product;
import com.foreign.team.toy.store.repository.CartItemRepository;
import com.foreign.team.toy.store.repository.CartRepository;
import com.foreign.team.toy.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartItemService(CartItemRepository cartItemRepository,
                           CartRepository cartRepository,
                           ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found with id: " + id));
    }

    public CartItem addItemToCart(Long cartId, Long productId, Integer quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + cartId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        Optional<CartItem> existingItem = cartItemRepository.findByCartAndProduct(cart, product);

        CartItem cartItem;
        if (existingItem.isPresent()) {
            cartItem = existingItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
        }

        BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
        cartItem.setTotalPrice(itemTotal);

        cartItemRepository.save(cartItem);

        updateCartTotalPrice(cart);

        return cartItem;
    }

    public CartItem updateCartItemQuantity(Long cartItemId, Integer newQuantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found with id: " + cartItemId));

        if (newQuantity == null || newQuantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        BigDecimal itemTotal = cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(newQuantity));
        cartItem.setTotalPrice(itemTotal);

        cartItemRepository.save(cartItem);
        updateCartTotalPrice(cartItem.getCart());

        return cartItem;
    }

    public void removeCartItem(Long cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found with id: " + cartItemId));

        Cart cart = cartItem.getCart();

        cartItemRepository.delete(cartItem);

        updateCartTotalPrice(cart);
    }

    public List<CartItem> getCartItemsByCartId(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + cartId));
        return cartItemRepository.findByCart(cart);
    }

    private void updateCartTotalPrice(Cart cart) {
        List<CartItem> cartItems = cartItemRepository.findByCart(cart);
        BigDecimal totalCartPrice = cartItems.stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        cart.setTotalPrice(totalCartPrice);
        cartRepository.save(cart);
    }
}