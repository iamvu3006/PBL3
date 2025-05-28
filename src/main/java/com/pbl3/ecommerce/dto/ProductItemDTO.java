package com.pbl3.ecommerce.dto;

import com.pbl3.ecommerce.entity.ProductItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductItemDTO {
    private static final Logger logger = LoggerFactory.getLogger(ProductItemDTO.class);

    private Integer productitemId;
    private Integer clientId;
    private Integer sellCategoryId;
    private String clientPhoneNumber;
    private String colorName;
    private String configurationHardDrive;
    private String productType;
    private String Inchs;
    private Integer productRam;
    private Integer internalMemory;
    private String brandName;
    private String tafiffPakageName;
    private String descriptedProduct;
    private String address;
    private Integer price;
    private Integer warranPeriod;
    private String version;
    private String productName;

    public ProductItemDTO(ProductItem item) {
        try {
            this.productitemId = item.getProductItemID();

            if (item.getAbClient() != null) {
                this.clientId = item.getAbClient().getClientID();

                if (item.getAbClient().getClientPhoneNumber() != null) {
                    this.clientPhoneNumber = item.getAbClient().getClientPhoneNumber();
                } else {
                    logger.warn("Số điện thoại không có tại client có ID: {}", item.getAbClient().getClientID());
                }
            } else {
                logger.warn("AbClient là null cho ProductItem có ID: {}", item.getProductItemID());
            }

            if (item.getSellCategory() != null) {
                this.sellCategoryId = item.getSellCategory().getSellCategoryID();
            } else {
                logger.warn("SellCategory là null cho ProductItem có ID: {}", item.getProductItemID());
            }

            if (item.getBrand() != null) {
                this.brandName = item.getBrand().getBrandName();
            } else {
                logger.warn("Brand là null cho ProductItem có ID: {}", item.getProductItemID());
            }

            if (item.getColor() != null) {
                this.colorName = item.getColor();
            } else {
                logger.warn("Color là null cho ProductItem có ID: {}", item.getProductItemID());
            }

            if (item.getRam() != null) {
                this.productRam = item.getRam();
            } else {
                logger.warn("Ram là null cho ProductItem có ID: {}", item.getProductItemID());
            }

            if (item.getInchs() != null) {
                this.Inchs = item.getInchs();
            } else {
                logger.warn("Inchs là null cho ProductItem có ID: {}", item.getProductItemID());
            }

            if (item.getProducttype() != null) {
                this.productType = item.getProducttype().toString();
            } else {
                logger.warn("ProductType là null cho ProductItem có ID: {}", item.getProductItemID());
            }

            if (item.getTariffiPackage() != null) {
                this.tafiffPakageName = item.getTariffiPackage().getPackageName();
            } else {
                logger.warn("TariffiPackage là null cho ProductItem có ID: {}", item.getProductItemID());
            }

            if (item.getHardDriveType() != null) {
                this.configurationHardDrive = item.getHardDriveType();
            } else {
                logger.warn("ConfigurationHardDrive là null cho ProductItem có ID: {}", item.getProductItemID());
            }

            if (item.getInternalmemory() != null) {
                this.internalMemory = item.getInternalmemory();
            } else {
                logger.warn("InternalMemory là null cho ProductItem có ID: {}", item.getProductItemID());
            }

        } catch (Exception e) {
            logger.error("Lỗi khi tạo ProductItemDTO từ entity: {}", e.getMessage(), e);
            throw e;
        }
    }

    public ProductItemDTO() {}

    // Getters
    public Integer getProductitemId() {
        return productitemId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getSellCategoryId() {
        return sellCategoryId;
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
        return Inchs;
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

    public String getTafiffPakageName() {
        return tafiffPakageName;
    }

    public String getDescriptedProduct() {
        return descriptedProduct;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getWarranPeriod() {
        return warranPeriod;
    }

    public String getVersion() {
        return version;
    }

    public String getProductName() {
        return productName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public void setConfigurationHardDrive(String configurationHardDrive) {
        this.configurationHardDrive = configurationHardDrive;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setInchs(String inchs) {
        this.Inchs = inchs;
    }

    public void setProductRam(Integer productRam) {
        this.productRam = productRam;
    }

    public void setInternalMemory(Integer internalMemory) {
        this.internalMemory = internalMemory;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setTafiffPakageName(String tafiffPakageName) {
        this.tafiffPakageName = tafiffPakageName;
    }

    public void setDescriptedProduct(String descriptedProduct) {
        this.descriptedProduct = descriptedProduct;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setWarranPeriod(Integer warranPeriod) {
        this.warranPeriod = warranPeriod;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
