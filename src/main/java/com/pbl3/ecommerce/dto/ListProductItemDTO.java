package com.pbl3.ecommerce.dto;

import com.pbl3.ecommerce.entity.ProductItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListProductItemDTO {
    private static final Logger logger = LoggerFactory.getLogger(ListProductItemDTO.class);
    private String productType;
    private String brandName;
    private String version;
    private String normalDescribe;
    private Double price;

    public ListProductItemDTO(ProductItem item) {
        try {
            if(item != null) {
                if(item.getBrand().getVersions() != null) {
                    this.version = item.getBrand().getVersions().getFirst().getVersionName();
                }

                if(item.getPrice() != 0){
                    this.price = item.getPrice();
                }

                if (item.getBrand() != null) {
                    this.brandName = item.getBrand().getBrandName();
                } else {
                    logger.warn("Brand là null cho ProductItem có ID: {}", item.getProductItemId());
                }

                if(item.getVersion().getVersionName() != null){
                    this.version = item.getVersion().getVersionName();
                } else{
                    logger.warn("Version null tai product co id: {}", item.getProductItemId());
                }

                if(item.getNormalDescribe() != null){
                    this.normalDescribe = item.getNormalDescribe();
                } else{
                    this.normalDescribe = "Chưa có mô tả"; // Gán giá trị mặc định
                    logger.warn("Mo ta don gian khong co tai san pham co if: {}", item.getProductItemId());
                }

                if (item.getProducttype() != null) {
                    this.productType = item.getProducttype().toString();
                } else {
                    logger.warn("ProductType là null cho ProductItem có ID: {}", item.getProductItemId());
                }
            }
        } catch (Exception e) {
            logger.error("Lỗi khi tạo ProductItemDTO từ entity: {}", e.getMessage(), e);
            throw e;
        }
    }

    // Getters

    public String getNormalDescribe() {
        return normalDescribe;
    }

    public String getProductType() {
        return productType;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getVersion() {
        return version;
    }

    public Double getPrice() {
        return price;
    }
}