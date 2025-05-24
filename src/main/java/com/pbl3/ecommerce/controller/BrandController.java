package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.entity.AbVersion;
import com.pbl3.ecommerce.entity.Brand;
import com.pbl3.ecommerce.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping("/{brandName}/versions")
    public ResponseEntity<List<AbVersion>> getVersionsByBrand(@PathVariable String brandName) {
        Brand brand = brandRepository.findByBrandName(brandName);
        if (brand != null) {
            return ResponseEntity.ok(brand.getVersions());
        }
        return ResponseEntity.notFound().build();
    }
} 