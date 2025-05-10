package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ProductItemDTO;
import com.pbl3.ecommerce.service.ProductItemSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductItemSellController {
    private static final Logger logger = LoggerFactory.getLogger(ProductItemSellController.class);

    @Autowired
    private ProductItemSellService productItemSellService;

    @GetMapping("/sell-category/{sellCategoryId}")
    public ResponseEntity<List<ProductItemDTO>> getProductsBySellCategory(@PathVariable Integer sellCategoryId) {
        logger.info("Nhận yêu cầu lấy sản phẩm với SellCategoryID: {}", sellCategoryId);

        try {
            List<ProductItemDTO> products = productItemSellService.ListProductBySellID(sellCategoryId);

            if (products.isEmpty()) {
                logger.info("Không tìm thấy sản phẩm nào với SellCategoryID: {}", sellCategoryId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            logger.info("Trả về {} sản phẩm với SellCategoryID: {}", products.size(), sellCategoryId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Lỗi khi xử lý yêu cầu cho SellCategoryID {}: {}", sellCategoryId, e.getMessage(), e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sell-category/product")


    @GetMapping("/sell-category/{sellCategoryId}/filter")
    public ResponseEntity<List<ProductItemDTO>> getProductsBySellCategoryAndType(
            @PathVariable Integer sellCategoryId,
            @RequestParam(required = false) String productType) {

        logger.info("Nhận yêu cầu lấy và lọc sản phẩm với SellCategoryID: {}, ProductType: {}",
                sellCategoryId, productType);

        try {
            List<ProductItemDTO> products = productItemSellService.ListProductBySellID(sellCategoryId);

            if (productType != null && !productType.isEmpty()) {
                int beforeFilterCount = products.size();
                products = products.stream()
                        .filter(p -> p.getProductType().equalsIgnoreCase(productType))
                        .toList();
                logger.info("Đã lọc từ {} sản phẩm xuống {} sản phẩm với ProductType: {}",
                        beforeFilterCount, products.size(), productType);
            }

            if (products.isEmpty()) {
                logger.info("Không tìm thấy sản phẩm nào phù hợp với điều kiện lọc");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            logger.info("Trả về {} sản phẩm sau khi lọc", products.size());
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Lỗi khi xử lý yêu cầu lọc: {}", e.getMessage(), e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
