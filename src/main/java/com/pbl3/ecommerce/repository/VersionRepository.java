package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.dto.VersionDTO;
import com.pbl3.ecommerce.entity.AbVersion;
import com.pbl3.ecommerce.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VersionRepository extends JpaRepository<AbVersion, Integer> {

    @Query("SELECT new com.pbl3.ecommerce.dto.VersionDTO(v.versionName) FROM AbVersion v WHERE v.brand.brandID = :brandID")
    List<VersionDTO> findVersionNamesByBrandID(Integer brandID);

    @Query("SELECT v FROM AbVersion v WHERE v.brand = :brand AND v.versionName = :versionName")
    AbVersion findByBrandAndVersionName(@Param("brand") Brand brand, @Param("versionName") String versionName);
}
