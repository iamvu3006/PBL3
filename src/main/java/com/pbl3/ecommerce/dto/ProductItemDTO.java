package com.pbl3.ecommerce.dto;


import com.pbl3.ecommerce.entity.ProductItem;
import jakarta.persistence.criteria.CriteriaBuilder;

public class ProductItemDTO {
    private Integer productitemId;
    private Integer clientId;
    private Integer sellCategoryId;
    private String colorName;
    private String configurationHardDrive;
    private String productType;
    private Double configurationInchs;
    private Integer productRam;
    private Integer internalMemory;
    private String brandName;
    private String tafiffPakageName;


    public ProductItemDTO(ProductItem item){
        this.productitemId = item.getProductItemID();
        this.clientId = item.getAbClient().getClientID();
        this.sellCategoryId = item.getSellCategory().getSellCategoryID();
        this.brandName = item.getBrand().getBrandName();
        this.colorName = item.getColor().getColorName();
        this.configurationHardDrive = item.getConfiguration().getHardDrive().toString();
        this.configurationInchs = item.getConfiguration().getInchs();
        this.productType = item.getProducttype().toString();
        this.productRam = item.getConfiguration().getGbMemory().getRam();
        this.internalMemory = item.getConfiguration().getGbMemory().getInternalMemory();
        this.tafiffPakageName = item.getTariffiPackage().getPackageName();
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

    public Double getConfigurationInchs() {
        return configurationInchs;
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
}


