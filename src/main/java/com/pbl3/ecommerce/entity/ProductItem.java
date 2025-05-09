package com.pbl3.ecommerce.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
     @OneToMany(mappedBy = "productItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Descripted> descripteds = new ArrayList<>();

    
    public List<Descripted> getDescripteds() {
        return descripteds;
    }
    public void setDescripteds(List<Descripted> descripteds) {
        this.descripteds = descripteds;
    }

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
