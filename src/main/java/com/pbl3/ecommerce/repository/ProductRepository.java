package com.pbl3.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbl3.ecommerce.entity.Product;

@Repository
public interface ProductRepository
    extends JpaRepository<Product, Long> {
    // JpaRepository đã cho sẵn findById(Long), findAll(), save(), deleteById()…
}