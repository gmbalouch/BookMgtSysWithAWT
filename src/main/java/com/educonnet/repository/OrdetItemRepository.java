package com.educonnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonnet.entity.OrderItem;

public interface OrdetItemRepository extends JpaRepository<OrderItem, Long> {

}
