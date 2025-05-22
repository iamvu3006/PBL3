package com.pbl3.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbl3.ecommerce.dto.PushProductItemDTO;
import com.pbl3.ecommerce.service.PushProductItemService;

@RestController
@RequestMapping("/api/products")
public class PushProductItemController {

    @Autowired
    private PushProductItemService productItemService;

    @PostMapping("/create")
    public String createProduct(@RequestBody PushProductItemDTO dto) throws Exception {
        productItemService.createProductItem(dto);
        return "Đăng bán sản phẩm thành công!";
    }
}
