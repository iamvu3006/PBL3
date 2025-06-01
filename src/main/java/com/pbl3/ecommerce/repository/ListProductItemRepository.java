package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListProductItemRepository extends JpaRepository<ProductItem, Integer> {
    @Query("SELECT p FROM ProductItem p JOIN p.productItemCategories pic JOIN pic.category c WHERE c.categoryID = :categoryId")
    List<ProductItem> findByCategoryId(@Param("categoryId") Integer categoryId);
}
