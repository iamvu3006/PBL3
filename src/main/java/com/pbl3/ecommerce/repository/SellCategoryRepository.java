package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.SellCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellCategoryRepository extends JpaRepository<SellCategory, Integer> {
}
