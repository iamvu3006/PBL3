package com.pbl3.ecommerce.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

public class PushProductItemDTO {
    private String descriptedProduct;
    private String productName;
    private Integer Price;
    private String Address;
    private Integer warranPeriod;
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
    private String Version;
    private String tafiffPakageName;

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public Integer getWarranPeriod() {
        return warranPeriod;
    }

    public void setWarranPeriod(Integer warranPeriod) {
        this.warranPeriod = warranPeriod;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getProductitemId() {
        return productitemId;
    }

    public void setProductitemId(Integer productitemId) {
        this.productitemId = productitemId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSellCategoryId() {
        return sellCategoryId;
    }

    public void setSellCategoryId(Integer sellCategoryId) {
        this.sellCategoryId = sellCategoryId;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getConfigurationHardDrive() {
        return configurationHardDrive;
    }

    public void setConfigurationHardDrive(String configurationHardDrive) {
        this.configurationHardDrive = configurationHardDrive;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getInchs() {
        return Inchs;
    }

    public void setInchs(String inchs) {
        Inchs = inchs;
    }

    public Integer getProductRam() {
        return productRam;
    }

    public void setProductRam(Integer productRam) {
        this.productRam = productRam;
    }

    public Integer getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(Integer internalMemory) {
        this.internalMemory = internalMemory;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTafiffPakageName() {
        return tafiffPakageName;
    }

    public void setTafiffPakageName(String tafiffPakageName) {
        this.tafiffPakageName = tafiffPakageName;
    }

    public String getDescriptedProduct() {
        return descriptedProduct;
    }

    public void setDescriptedProduct(String descriptedProduct) {
        this.descriptedProduct = descriptedProduct;
    }
}
