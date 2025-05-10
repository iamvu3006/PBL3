package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "productitem")
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productItemID;

    @Enumerated(EnumType.STRING)
    private ProductType producttype;

    public ProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    @ManyToOne
    @JoinColumn(name = "Clientid")
    private AbClient abclient;

    @ManyToOne
    @JoinColumn(name = "ColorID")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "ConfigurationID")
    private Configuration configuration;

    @ManyToOne
    @JoinColumn(name = "BrandID")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "TariffiPackageID")
    private TariffiPackage tariffiPackage;

    @ManyToOne
    @JoinColumn(name = "SellCategoryID")
    private SellCategory sellCategory;

    // Getters & Setters
    public enum ProductType{
        Laptop, Phone
    }
    public Integer getProductItemID() {
        return productItemID;
    }

    private void setProductItemID(Integer productItemID) {
        this.productItemID = productItemID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public TariffiPackage getTariffiPackage() {
        return tariffiPackage;
    }

    public void setTariffiPackage(TariffiPackage tariffiPackage) {
        this.tariffiPackage = tariffiPackage;
    }

    public SellCategory getSellCategory() {
        return sellCategory;
    }

    private void setSellCategory(SellCategory sellCategory) {
        this.sellCategory = sellCategory;
    }

    public AbClient getAbClient() {
        return abclient;
    }

    private void setAbClient(AbClient abClient) {
        this.abclient = abClient;
    }
}
