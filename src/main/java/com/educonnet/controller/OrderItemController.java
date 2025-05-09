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

import com.educonnet.entity.OrderItem;
import com.educonnet.service.OrderItemService;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/add")
    public ResponseEntity<OrderItem> addOrderItem(@RequestParam Long orderId,
            @RequestParam Long bookId,
            @RequestParam int quantity,
            @RequestParam double price) {
        return ResponseEntity.ok(orderItemService.addOrderItem(orderId, bookId, quantity, price));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.ok("Order item deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id,
            @RequestParam int quantity,
            @RequestParam double price) {
        return ResponseEntity.ok(orderItemService.updateOrderItem(id, quantity, price));
    }

    @GetMapping("/view")
    public ResponseEntity<List<OrderItem>> viewOrderItems() {
        return ResponseEntity.ok(orderItemService.viewOrderItems());
    }

}
