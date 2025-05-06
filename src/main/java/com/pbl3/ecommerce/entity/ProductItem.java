package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "productitem")
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productItemID;

    @Enumerated(EnumType.STRING)
    private ProductRole productRole;

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

    public enum ProductRole {
        Seller, Buyer
    }

    // Getters & Setters

    public Integer getProductItemID() {
        return productItemID;
    }

    public void setProductItemID(Integer productItemID) {
        this.productItemID = productItemID;
    }

    public ProductRole getProductRole() {
        return productRole;
    }

    public void setProductRole(ProductRole productRole) {
        this.productRole = productRole;
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

    public void setSellCategory(SellCategory sellCategory) {
        this.sellCategory = sellCategory;
    }
}
