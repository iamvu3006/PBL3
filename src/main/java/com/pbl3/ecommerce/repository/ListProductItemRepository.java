    package com.pbl3.ecommerce.repository;

    import com.pbl3.ecommerce.entity.ProductItem;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    import java.util.List;

    public interface ListProductItemRepository extends JpaRepository<ProductItem, Integer> {
        @Query("SELECT p FROM ProductItem p JOIN p.productItemCategories pic JOIN pic.category c WHERE c.categoryID = :categoryId")
        List<ProductItem> findByCategoryId(@Param("categoryId") Integer categoryId);

        @Query("""
                SELECT p FROM ProductItem p
                WHERE (:brand IS NULL OR p.Brandid.brandName = :brand)
                AND (:minPrice IS NULL OR p.price >= :minPrice)
                AND (:maxPrice IS NULL OR p.price <= :maxPrice)
                """)
        List<ProductItem> filterProducts(
                @Param("brand") String brand,
                @Param("minPrice") Double minPrice,
                @Param("maxPrice") Double maxPrice
        );

    }
