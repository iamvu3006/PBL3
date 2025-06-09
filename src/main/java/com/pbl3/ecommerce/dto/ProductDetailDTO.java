package com.pbl3.ecommerce.dto;

import java.util.List;

public class ProductDetailDTO {
    private Integer productitemId;
    private String productName;
    private Double price;
    private Integer warranPeriod;
    private String address;
    private String imageUrl;        // Ảnh chính
    private List<String> imageUrls; // Các ảnh phụ (URL)
    private String descriptedProduct;

    private String brandName;
    private String productType;
    private String inchs;
    private Integer productRam;
    private Integer internalMemory;
    private String configurationHardDrive;
    private String colorName;
    private String version;
    private String tafiffPakageName;
    private String categoryName;
    private Integer sellCategoryId;

    
    public Integer getProductitemId() { return productitemId; }
    public void setProductitemId(Integer productitemId) { this.productitemId = productitemId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    // ... các phương thức khác ...

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getWarranPeriod() {
        return warranPeriod;
    }

    public void setWarranPeriod(Integer warranPeriod) {
        this.warranPeriod = warranPeriod;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescriptedProduct() {
        return descriptedProduct;
    }

    public void setDescriptedProduct(String descriptedProduct) {
        this.descriptedProduct = descriptedProduct;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getInchs() {
        return inchs;
    }

    public void setInchs(String inchs) {
        this.inchs = inchs;
    }

    public Integer getProductRam() {
        return productRam;
    }

    public void setProductRam(Integer productRam) {
        this.productRam = productRam;
    }

    public String getConfigurationHardDrive() {
        return configurationHardDrive;
    }

    public void setConfigurationHardDrive(String configurationHardDrive) {
        this.configurationHardDrive = configurationHardDrive;
    }

    public Integer getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(Integer internalMemory) {
        this.internalMemory = internalMemory;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTafiffPakageName() {
        return tafiffPakageName;
    }

    public void setTafiffPakageName(String tafiffPakageName) {
        this.tafiffPakageName = tafiffPakageName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSellCategoryId() {
        return sellCategoryId;
    }

    public void setSellCategoryId(Integer sellCategoryId) {
        this.sellCategoryId = sellCategoryId;
    }
}
