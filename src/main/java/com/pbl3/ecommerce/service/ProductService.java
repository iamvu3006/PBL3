package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.ProductDetailDTO;

public interface ProductService {
    /**
     * Lấy chi tiết sản phẩm và ánh xạ sang DTO ProductDetailDTO.
     */
    ProductDetailDTO getProductDetailById(Integer id);
}
