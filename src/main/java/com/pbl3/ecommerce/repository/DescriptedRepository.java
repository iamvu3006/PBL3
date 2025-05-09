package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.Descripted;
import com.pbl3.ecommerce.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescriptedRepository extends JpaRepository<Descripted, Integer> {
    List<Descripted> findByProductItem(ProductItem productItem);
}

