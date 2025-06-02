package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ListProductItemDTO;
import com.pbl3.ecommerce.dto.ProductItemDetailDTO;
import com.pbl3.ecommerce.service.ListProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productitems")
public class ListProductItemController {

    @Autowired
    private ListProductService listProductService;

    // Lấy tất cả sản phẩm
    @GetMapping
    public ResponseEntity<List<ListProductItemDTO>> getAllProducts() {
        List<ListProductItemDTO> products = listProductService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Lấy sản phẩm theo categoryId
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable Integer categoryId) {
        if (categoryId == null || categoryId <= 0) {
            return new ResponseEntity<>("Category ID không hợp lệ", HttpStatus.BAD_REQUEST);
        }

        List<ListProductItemDTO> products = listProductService.getProductItemsByCategoryId(categoryId);

        if (products == null || products.isEmpty()) {
            return new ResponseEntity<>("Không tìm thấy sản phẩm nào thuộc danh mục này", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductItemDetailByProductId(@PathVariable Integer productId){
        if(productId == null || productId <= 0){
            return new ResponseEntity<>("ProductId khong hop le", HttpStatus.BAD_REQUEST);
        }

        ProductItemDetailDTO productItemDetail = listProductService.getProductItemDetailByProductId(productId);

        if(productItemDetail == null){
            return new ResponseEntity<>("Loi khi truy cap vao chi ti tiet san pham", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productItemDetail,HttpStatus.OK);
    }
}
