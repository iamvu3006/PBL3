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
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import com.pbl3.ecommerce.dto.PushProductItemDTO;
import com.pbl3.ecommerce.service.PushProductItemService;
import com.pbl3.ecommerce.repository.BrandRepository;
import com.pbl3.ecommerce.repository.SellCategoryRepository;
import com.pbl3.ecommerce.repository.TariffiPackageRepository;
import com.pbl3.ecommerce.dto.ProductItemResponseDTO;

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
    public ResponseEntity<String> createProduct(
            @RequestBody PushProductItemDTO dto,
            HttpSession session) {

        // Kiểm tra đăng nhập
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn == null || !isLoggedIn) {
            return ResponseEntity.status(401).body("Vui lòng đăng nhập");
        }

        // Lấy username từ session
        String username = (String) session.getAttribute("username");

        try {
            ProductItemResponseDTO res = productItemService.createProductItemAndReturnDTO(dto, username); // Truyền username vào
            return ResponseEntity.ok("Đăng bán sản phẩm thành công!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Lỗi: " + e.getMessage());
        }
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("categories", sellCatRepo.findAll());
        model.addAttribute("tariffs", tariffRepo.findAll());
        return "create";
    }
}
