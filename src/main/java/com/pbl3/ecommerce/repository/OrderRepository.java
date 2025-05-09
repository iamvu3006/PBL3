package com.pbl3.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbl3.ecommerce.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {}