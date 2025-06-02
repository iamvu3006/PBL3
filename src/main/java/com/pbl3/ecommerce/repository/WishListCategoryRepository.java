package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.WishListCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListCategoryRepository extends JpaRepository<WishListCategory, Integer> {
}

