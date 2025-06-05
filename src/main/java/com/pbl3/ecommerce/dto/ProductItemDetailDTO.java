package com.pbl3.ecommerce.dto;

import com.pbl3.ecommerce.entity.ProductItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductItemDetailDTO {
    private static final Logger logger = LoggerFactory.getLogger(ProductItemDetailDTO.class);

    private String clientPhoneNumber;
    private Double price;
    private String descripted;
    private String colorName;
    private String configurationHardDrive;
    private String productType;
    private String inchs;
    private String version;
    private Integer productRam;
    private Integer internalMemory;
    private String brandName;

    public ProductItemDetailDTO(ProductItem item) {
        try {

            if (item.getAbClient() != null) {
                if (item.getAbClient().getClientPhoneNumber() != null) {
                    this.clientPhoneNumber = item.getAbClient().getClientPhoneNumber();
                } else {
                    logger.warn("Số điện thoại không có tại client có ID: {}", item.getAbClient().getClientID());
                }
            } else {
                logger.warn("Co loi khi lay so dien thoai tai san pham: {}", item.getProductItemId());
            }

            if(item.getPrice() == 0){
                this.price = item.getPrice();
            } else{
                logger.warn("Co loi khi truy xuat gia tai san pham co id: {}", item.getProductItemId());
            }
            if(item.getVersion().getVersionName() != null){
                this.version = item.getVersion().getVersionName();
            } else{
                logger.warn("Co loi khi lay so phien ban san pham tai san pham:{}", item.getProductItemId());
            }

            if (item.getBrand() != null) {
                this.brandName = item.getBrand().getBrandName();
            } else {
                logger.warn("Brand là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if (item.getColor() != null) {
                this.colorName = item.getColor();
            } else {
                logger.warn("Color là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if (item.getRam() != null) {
                this.productRam = item.getRam();
            } else {
                logger.warn("Ram là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if (item.getInchs() != null) {
                this.inchs = item.getInchs();
            } else {
                logger.warn("inchs là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if (item.getProducttype() != null) {
                this.productType = item.getProducttype().toString();
            } else {
                logger.warn("ProductType là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if (item.getHardDriveType() != null) {
                this.configurationHardDrive = item.getHardDriveType();
            } else {
                logger.warn("ConfigurationHardDrive là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if (item.getInternalmemory() != null) {
                this.internalMemory = item.getInternalmemory();
            } else {
                logger.warn("InternalMemory là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if(item.getDescriptedID() != null) {
                this.descripted = item.getDescriptedID().getDescripted();
            } else{
                logger.warn("Loi khi lay descipted tai san pham " + item.getProductItemId());
            }

        } catch (Exception e) {
            logger.error("Lỗi khi tạo ProductItemDTO từ entity: {}", e.getMessage(), e);
            throw e;
        }
    }


    // Getters

    public Double getPrice() {
        return price;
    }

    public String getVersion() {
        return version;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public String getColorName() {
        return colorName;
    }

    public String getConfigurationHardDrive() {
        return configurationHardDrive;
    }

    public String getProductType() {
        return productType;
    }

    public String getInchs() {
        return inchs;
    }

    public Integer getProductRam() {
        return productRam;
    }

    public Integer getInternalMemory() {
        return internalMemory;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getDescripted() {
        return descripted;
    }


}
