package com.pbl3.ecommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.service.ProductItemService;

@Controller
@RequestMapping("/products")
public class ProductItemController {

    @Autowired
    private ProductItemService productItemService;

    @GetMapping
    public String showProductList(Model model) {
        List<Map<String, Object>> products = productItemService.getAllProductDisplayData();
        model.addAttribute("products", products);
        return "product_list"; // Tên view Thymeleaf
    }
    @GetMapping("/search")
    public String searchProducts(@RequestParam("keyword") String keyword, Model model) {
        List<ProductItem> products = productItemService.searchProducts(keyword);
        model.addAttribute("products", products);
        return "product/search-result"; // Tên view hiển thị kết quả
    }
    
}
