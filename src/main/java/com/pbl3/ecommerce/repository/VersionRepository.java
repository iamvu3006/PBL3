package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.dto.VersionDTO;
import com.pbl3.ecommerce.entity.AbVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VersionRepository extends JpaRepository<AbVersion, Integer> {

    @Query("SELECT new com.pbl3.ecommerce.dto.VersionDTO(v.versionName) FROM AbVersion v WHERE v.brand.brandID = :brandID")
    List<VersionDTO> findVersionNamesByBrandID(Integer brandID);
}
