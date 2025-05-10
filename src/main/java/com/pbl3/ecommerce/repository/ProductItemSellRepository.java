package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemSellRepository extends JpaRepository<ProductItem, Integer> {
    @Query("SELECT p FROM ProductItem p WHERE p.sellCategory.sellCategoryID = :sellCategoryID")
    List<ProductItem> ListProductBySellID(@Param("sellCategoryID") Integer sellCategoryID);
}
