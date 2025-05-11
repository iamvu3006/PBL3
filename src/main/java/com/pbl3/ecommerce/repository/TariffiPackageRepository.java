package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.TariffiPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffiPackageRepository extends JpaRepository<TariffiPackage, Integer> {
    TariffiPackage findByPackageName(String packageName);
}