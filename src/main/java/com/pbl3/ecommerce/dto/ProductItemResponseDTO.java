package com.pbl3.ecommerce.dto;

public class ProductItemResponseDTO {
    private Integer productItemId;
    private String productType;
    private String status;
    private Double price;
    private String color;
    private Integer ram;
    private String inchs;
    private Integer internalMemory;
    private String hardDriveType;
    private String normalDescribe;

    // Client info (chỉ những thông tin cần thiết)
    private Integer clientId;
    private String clientUseName;
    private String clientFullName;
    private String clientPhoneNumber;

    // Brand info
    private Integer brandId;
    private String brandName;

    // Version info
    private Integer versionId;
    private String versionName;

    // Tariff Package info
    private Integer tariffiPackageId;
    private String tariffiPackageName;

    // Descripted info
    private String productName;
    private String descriptedProduct;
    private String address;
    private Integer warrantyPeriod;

    // SellCategory info
    private Integer sellCategoryId;

    // Constructors
    public ProductItemResponseDTO() {}

    // Getters and Setters
    public Integer getProductItemId() {
        return productItemId;
    }

    public void setProductItemId(Integer productItemId) {
        this.productItemId = productItemId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getInchs() {
        return inchs;
    }

    public void setInchs(String inchs) {
        this.inchs = inchs;
    }

    public Integer getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(Integer internalMemory) {
        this.internalMemory = internalMemory;
    }

    public String getHardDriveType() {
        return hardDriveType;
    }

    public void setHardDriveType(String hardDriveType) {
        this.hardDriveType = hardDriveType;
    }

    public String getNormalDescribe() {
        return normalDescribe;
    }

    public void setNormalDescribe(String normalDescribe) {
        this.normalDescribe = normalDescribe;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientUseName() {
        return clientUseName;
    }

    public void setClientUseName(String clientUseName) {
        this.clientUseName = clientUseName;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getTariffiPackageId() {
        return tariffiPackageId;
    }

    public void setTariffiPackageId(Integer tariffiPackageId) {
        this.tariffiPackageId = tariffiPackageId;
    }

    public String getTariffiPackageName() {
        return tariffiPackageName;
    }

    public void setTariffiPackageName(String tariffiPackageName) {
        this.tariffiPackageName = tariffiPackageName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescriptedProduct() {
        return descriptedProduct;
    }

    public void setDescriptedProduct(String descriptedProduct) {
        this.descriptedProduct = descriptedProduct;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Integer warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Integer getSellCategoryId() {
        return sellCategoryId;
    }

    public void setSellCategoryId(Integer sellCategoryId) {
        this.sellCategoryId = sellCategoryId;
    }
}
