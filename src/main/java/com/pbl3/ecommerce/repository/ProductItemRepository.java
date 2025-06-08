package com.pbl3.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pbl3.ecommerce.entity.ProductItem;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {

    @Query("""
      SELECT p 
      FROM ProductItem p
      JOIN p.descripted d
      WHERE LOWER(d.productName) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    List<ProductItem> searchByProductName(@Param("keyword") String keyword);
    List<ProductItem> findByStatus(ProductItem.Status status);
}
