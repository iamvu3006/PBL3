package com.pbl3.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.repository.ProductItemDetailRepository;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductItemDetailRepository productRepo;

    @Autowired
    public ProductController(ProductItemDetailRepository productRepo) {
        this.productRepo = productRepo;
    }

    
    @GetMapping("/{id}")
    public String viewProductDetail(@PathVariable("id") Integer id,
                                    Model model) {
        // 1. Lấy entity từ DB
        ProductItem item = productRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sản phẩm #" + id));

        // 2. Đẩy vào model
        model.addAttribute("product", item);

        // 3. Trả về tên Thymeleaf template
        return "product_detail";
    }
}
