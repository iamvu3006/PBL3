package com.pbl3.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbl3.ecommerce.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}