package com.pbl3.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pbl3.ecommerce.dto.PushProductItemDTO;
import com.pbl3.ecommerce.service.PushProductItemService;
import com.pbl3.ecommerce.repository.BrandRepository;
import com.pbl3.ecommerce.repository.SellCategoryRepository;
import com.pbl3.ecommerce.repository.TariffiPackageRepository;

@Controller
@RequestMapping("/api/products")
public class PushProductItemController {

    @Autowired
    private PushProductItemService productItemService;

    @Autowired
    private BrandRepository brandRepo;
    @Autowired
    private SellCategoryRepository sellCatRepo;
    @Autowired
    private TariffiPackageRepository tariffRepo;

    @PostMapping("/create")
    @ResponseBody
    public String createProduct(@RequestBody PushProductItemDTO dto) throws Exception {
        productItemService.createProductItem(dto);
        return "Đăng bán sản phẩm thành công!";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("categories", sellCatRepo.findAll());
        model.addAttribute("tariffs", tariffRepo.findAll());
        // Nếu có clientId, bạn có thể lấy từ session hoặc security context
        // model.addAttribute("clientId", ...);
        return "create";
    }
}