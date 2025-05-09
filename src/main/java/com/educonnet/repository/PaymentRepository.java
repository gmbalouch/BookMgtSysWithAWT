package com.educonnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educonnet.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}