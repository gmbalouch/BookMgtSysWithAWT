package com.educonnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonnet.entity.Book;
import com.educonnet.entity.Order;
import com.educonnet.entity.OrderItem;
import com.educonnet.repository.BookRepository;
import com.educonnet.repository.OrderRepository;
import com.educonnet.repository.OrdetItemRepository;

@Service
public class OrderItemService {
    @Autowired
    private OrdetItemRepository orderItemRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderItem addOrderItem(Long orderId, Long bookId, int quantity, double price) {
        Optional<Order> order = orderRepository.findById(orderId);
        Optional<Book> book = bookRepository.findById(bookId);

        if (order.isEmpty() || book.isEmpty()) {
            throw new RuntimeException("Order or Book not found");
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order.get());
        orderItem.setBook(book.get());
        orderItem.setQuantity(quantity);
        orderItem.setPrice(price);

        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    public OrderItem updateOrderItem(Long id, int quantity, double price) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        orderItem.setQuantity(quantity);
        orderItem.setPrice(price);

        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> viewOrderItems() {
        return orderItemRepository.findAll();
    }
}
