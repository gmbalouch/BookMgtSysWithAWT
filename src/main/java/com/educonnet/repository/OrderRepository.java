package com.educonnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonnet.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
