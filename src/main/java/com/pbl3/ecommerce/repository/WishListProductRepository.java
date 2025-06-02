package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.WishListProduct;
import com.pbl3.ecommerce.entity.WishListProductId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListProductRepository extends JpaRepository<WishListProduct, WishListProductId> {

    boolean existsByWishListCategory_wishListIDAndProductItem_ProductItemId(Integer wishListId, Integer productId);

    void deleteByWishListCategory_wishListIDAndProductItem_ProductItemId(Integer wishListId, Integer productId);

    List<WishListProduct> findByWishListCategory_abClient_clientID(Integer clientId);
}
