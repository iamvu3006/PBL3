package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.AbClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetClientRepository extends JpaRepository<AbClient, Integer> {
}

