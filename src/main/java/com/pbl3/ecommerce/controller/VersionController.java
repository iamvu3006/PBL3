package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.VersionDTO;
import com.pbl3.ecommerce.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/versions")
@CrossOrigin(origins = "*")
public class VersionController {
     @Autowired
    private VersionService versionService;

    @GetMapping("/by-brand/{brandID}")
    public List<VersionDTO> getVersionsByBrand(@PathVariable Integer brandID) {
        return versionService.getVersionsByBrand(brandID);
    }
}
