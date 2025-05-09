package com.educonnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educonnet.entity.CartItem;
import com.educonnet.service.CartItemService;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestParam Long userId,
            @RequestParam Long bookId,
            @RequestParam int quantity) {
        CartItem cartItem = cartItemService.addItemToCart(userId, bookId, quantity);
        return ResponseEntity.ok(cartItem);
    }

    @GetMapping("/view/{userId}")
    public ResponseEntity<List<CartItem>> viewCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartItemService.viewCart(userId));
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long cartItemId) {
        cartItemService.deleteItem(cartItemId);
        return ResponseEntity.ok("Item deleted from cart");
    }

    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long cartItemId,
            @RequestParam(required = false) Long bookId,
            @RequestParam(required = false) Integer quantity) {
        CartItem updatedItem = cartItemService.updateCartItem(cartItemId, bookId, quantity);
        return ResponseEntity.ok(updatedItem);
    }

}
