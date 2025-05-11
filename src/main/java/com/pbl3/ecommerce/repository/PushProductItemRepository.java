package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PushProductItemRepository extends JpaRepository<ProductItem, Integer> {
}
