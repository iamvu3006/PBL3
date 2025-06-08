package com.pbl3.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbl3.ecommerce.entity.WishListCategory;

@Repository
public interface WishListCategoryRepository extends JpaRepository<WishListCategory, Integer> {

    public Optional<WishListCategory> findByAbClient_ClientID(Integer clientId);
}

