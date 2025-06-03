package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.VersionDTO;
import com.pbl3.ecommerce.repository.VersionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionService {

    private final VersionRepository versionRepository;

    public VersionService(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    public List<VersionDTO> getVersionsByBrand(Integer brandID) {
        return versionRepository.findVersionNamesByBrandID(brandID);
    }
}
