package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ProductItemDTO;
import com.pbl3.ecommerce.service.ProductItemSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Tùy chỉnh theo nhu cầu CORS của bạn
public class ProductItemSellController {

    @Autowired
    private ProductItemSellService productItemSellService;

    /**
     * Lấy danh sách sản phẩm theo Sell Category ID
     * @param sellCategoryId ID của sell category cần lấy sản phẩm
     * @return Danh sách ProductItemDTO
     */
    @GetMapping("/sell-category/{sellCategoryId}")
    public ResponseEntity<List<ProductItemDTO>> getProductsBySellCategory(@PathVariable Integer sellCategoryId) {
        try {
            List<ProductItemDTO> products = productItemSellService.ListProductBySellID(sellCategoryId);

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * API endpoint để lấy tất cả sản phẩm trong một danh mục bán hàng và lọc theo loại sản phẩm
     * @param sellCategoryId ID của sell category
     * @param productType Loại sản phẩm (Laptop/Phone) - không bắt buộc
     * @return Danh sách sản phẩm phù hợp điều kiện
     */
    @GetMapping("/sell-category/{sellCategoryId}/filter")
    public ResponseEntity<List<ProductItemDTO>> getProductsBySellCategoryAndType(
            @PathVariable Integer sellCategoryId,
            @RequestParam(required = false) String productType) {

        try {
            // Lấy toàn bộ sản phẩm theo sellCategoryId
            List<ProductItemDTO> products = productItemSellService.ListProductBySellID(sellCategoryId);

            // Nếu có chỉ định productType thì lọc
            if (productType != null && !productType.isEmpty()) {
                products = products.stream()
                        .filter(p -> p.getProductType().equalsIgnoreCase(productType))
                        .toList();
            }

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}