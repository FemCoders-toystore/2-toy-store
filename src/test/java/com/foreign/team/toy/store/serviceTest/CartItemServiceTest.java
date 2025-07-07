package com.foreign.team.toy.store.serviceTest;

import com.foreign.team.toy.store.model.Cart;
import com.foreign.team.toy.store.model.CartItem;
import com.foreign.team.toy.store.model.Product;
import com.foreign.team.toy.store.repository.CartItemRepository;
import com.foreign.team.toy.store.repository.CartRepository;
import com.foreign.team.toy.store.repository.ProductRepository;
import com.foreign.team.toy.store.exceptions.ResourceNotFoundException;
import com.foreign.team.toy.store.service.CartItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class CartItemServiceTest {

    @Mock
    private CartItemRepository cartItemRepository;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CartItemService cartItemService;

    private Cart cart;
    private Product product;
    private CartItem cartItem;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        cart.setId(1L);

        product = new Product();
        product.setId(1L);
        product.setPrice(BigDecimal.valueOf(10));

        cartItem = new CartItem();
        cartItem.setId(1L);
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(2);
        cartItem.setTotalPrice(BigDecimal.valueOf(20));
    }

    @Test
    void testAddCartItem_Success() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(cartItemRepository.save(any(CartItem.class))).thenReturn(cartItem);

        CartItem result = cartItemService.addItemToCart(1L, 1L, 2);

        assertNotNull(result);
        assertEquals(2, result.getQuantity());
        assertEquals(BigDecimal.valueOf(20), result.getTotalPrice());
        verify(cartItemRepository).save(any(CartItem.class));
    }

    @Test
    void testAddCartItem_CartNotFound() {
        when(cartRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> cartItemService.addItemToCart(99L, 1L, 1));
    }

    @Test
    void testAddCartItem_ProductNotFound() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> cartItemService.addItemToCart(1L, 99L, 1));
    }

    @Test
    void testRemoveCartItem_Success() {
        when(cartItemRepository.findById(1L)).thenReturn(Optional.of(cartItem));

        cartItemService.removeCartItem(1L);

        verify(cartItemRepository).delete(cartItem);
    }

    @Test
    void testRemoveCartItem_NotFound() {
        when(cartItemRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> cartItemService.removeCartItem(99L));
    }
}
