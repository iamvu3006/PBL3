package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemSellRepository extends JpaRepository<ProductItem, Integer> {

    @Query(value = "SELECT * FROM productitem WHERE sell_categoryid = :sellCategoryID", nativeQuery = true)
    List<ProductItem> findBySellCategoryIDNative(@Param("sellCategoryID") Integer sellCategoryID);

    // Thêm truy vấn đếm tổng số sản phẩm, ko can cung duoc
    @Query("SELECT COUNT(p) FROM ProductItem p")
    long countAllProducts();
}
