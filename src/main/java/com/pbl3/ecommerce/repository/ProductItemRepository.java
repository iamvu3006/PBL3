package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {
    @Query("SELECT p FROM ProductItem p JOIN Descripted d ON d.productItem = p WHERE d.productName LIKE %:keyword%")
    List<ProductItem> searchByProductName(@Param("keyword") String keyword);
}