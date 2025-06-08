package com.pbl3.ecommerce.dto;

import com.pbl3.ecommerce.entity.ProductItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductItemDTO {
    private static final Logger logger = LoggerFactory.getLogger(ProductItemDTO.class);

    private String clientPhoneNumber;
    private String descripted;
    private String colorName;
    private String configurationHardDrive;
    private String productType;
    private String Inchs;
    private String normalDescribe;
    private String version;
    private double price;
    private Integer productRam;
    private Integer internalMemory;
    private String brandName;
    private String tafiffPakageName;

    public ProductItemDTO(ProductItem item) {
        try {


            if (item.getAbClient() != null) {
                if (item.getAbClient().getClientPhoneNumber() != null) {
                    this.clientPhoneNumber = item.getAbClient().getClientPhoneNumber();
                } else {
                    logger.warn("Số điện thoại không có tại client có ID: {}", item.getAbClient().getClientID());
                }
            } else {
                logger.warn("AbClient là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if(item.getPrice() != 0){
                this.price = item.getPrice();
            } else{
                logger.warn("Co loi khi lay gia san pham tai :{}", item.getProductItemId());
            }

            if(item.getVersion().getVersionName() != null){
                this.version = item.getVersion().getVersionName();
            } else{
                logger.warn("Co loi khi lay so phien ban san pham tai san pham:{}", item.getProductItemId());
            }

            if(item.getNormalDescribe() != null){
                this.normalDescribe = item.getNormalDescribe();
            } else{
                logger.warn("Mo ta don gian khong co tai san pham co if: {}", item.getProductItemId());
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
                this.Inchs = item.getInchs();
            } else {
                logger.warn("Inchs là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if (item.getProducttype() != null) {
                this.productType = item.getProducttype().toString();
            } else {
                logger.warn("ProductType là null cho ProductItem có ID: {}", item.getProductItemId());
            }

            if (item.getTariffiPackage() != null) {
                this.tafiffPakageName = item.getTariffiPackage().getPackageName();
            } else {
                logger.warn("TariffiPackage là null cho ProductItem có ID: {}", item.getProductItemId());
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

    public ProductItemDTO(){ }

    // Getters
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

    public String getNormalDescribe() {
        return normalDescribe;
    }

    public String getVersion() {
        return version;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNormalDescribe(String normalDescribe) {
        this.normalDescribe = normalDescribe;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getDescripted() {
        return descripted;
    }

    public void setDescripted(String descripted) {
        this.descripted = descripted;
    }
}
