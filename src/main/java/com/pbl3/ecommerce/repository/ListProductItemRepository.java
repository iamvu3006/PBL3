package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.entity.ProductItem.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListProductItemRepository extends JpaRepository<ProductItem, Integer> {

    // Lấy tất cả sản phẩm đã được duyệt
    List<ProductItem> findByStatus(Status status);

    // Lấy sản phẩm theo category và đã được duyệt
    @Query("""
            SELECT p FROM ProductItem p 
            JOIN p.productItemCategories pic 
            JOIN pic.category c 
            WHERE c.categoryID = :categoryId 
            AND p.status = 'APPROVED'
           """)
    List<ProductItem> findApprovedByCategoryId(@Param("categoryId") Integer categoryId);

    // Lọc theo brand, giá và chỉ lấy sản phẩm đã được duyệt
    @Query("""
            SELECT p FROM ProductItem p 
            WHERE p.status = 'APPROVED'
            AND (:brand IS NULL OR p.Brandid.brandName = :brand)
            AND (:minPrice IS NULL OR p.price >= :minPrice)
            AND (:maxPrice IS NULL OR p.price <= :maxPrice)
           """)
    List<ProductItem> filterProducts(
            @Param("brand") String brand,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice
    );
}
