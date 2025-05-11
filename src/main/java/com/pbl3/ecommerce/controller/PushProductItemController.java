package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.PushProductItemDTO;
import com.pbl3.ecommerce.service.PushProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
