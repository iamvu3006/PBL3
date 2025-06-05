package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "productitem")
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productItemId;

    @Enumerated(EnumType.STRING)
    @Column(name = "producttype")
    private ProductType producttype;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private AbClient abclient;

    @Column(name = "price")
    private Double price;

    @Column(name = "Color")
    private String Color;

    @Column(name = "ram")
    private Integer Ram;

    @Column(name = "inchs")
    private String Inchs;

    @Column(name = "internalmemory")
    private Integer InternalMemory;

    @Column(name = "harddrivetype")
    private String HardDriveType;

    @Column(name = "normaldescribe")
    private String NormalDescribe;

    @ManyToOne
    @JoinColumn(name = "versionid")
    private AbVersion version;

    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand Brandid;

    @ManyToOne
    @JoinColumn(name = "tariffi_packageid")
    private TariffiPackage TariffiPackage;

    @ManyToOne
    @JoinColumn(name = "sell_categoryid")
    private SellCategory SellCategory;

    @OneToOne(cascade = CascadeType.PERSIST) //Luu du luu cua descripted roi moi luu productitem
    @JoinColumn(name = "describeid")
    private Descripted descripted;

    @OneToMany(mappedBy = "productItem")
    private List<ProductItemCategory> productItemCategories = new ArrayList<>();

    // Getters & Setters


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public AbClient getAbclient() {
        return abclient;
    }

    public Integer getInternalMemory() {
        return InternalMemory;
    }

    public AbVersion getVersion() {
        return version;
    }

    public Brand getBrandid() {
        return Brandid;
    }

    public Descripted getDescripted() {
        return descripted;
    }

    public String getNormalDescribe() {
        return NormalDescribe;
    }

    public void setNormalDescribe(String normalDescribe) {
        NormalDescribe = normalDescribe;
    }

    public ProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    public String getInchs() {
        return Inchs;
    }

    public void setInchs(String inchs) {
        this.Inchs = inchs;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    public Integer getRam() {
        return Ram;
    }

    public void setRam(Integer ram) {
        this.Ram = ram;
    }

    public Integer getInternalmemory() {
        return InternalMemory;
    }

    public void setInternalmemory(Integer internalmemory) {
        this.InternalMemory = internalmemory;
    }

    public Brand getBrand() {
        return Brandid;
    }

    public Descripted getDescriptedID() {

        return descripted;
    }

    public void setDescriptedID(Descripted descriptedID) {
        descripted = descriptedID;
    }

    public void setBrand(Brand brand) {
        this.Brandid = brand;
    }

    public enum ProductType{
        LAPTOP, PHONE
    }
    public Integer getProductItemId() {
        return productItemId;
    }

    private void setProductItemId(Integer productItemId) {
        this.productItemId = productItemId;
    }

    public TariffiPackage getTariffiPackage() {
        return TariffiPackage;
    }


    public SellCategory getSellCategory() {
        return SellCategory;
    }

    public void setSellCategory(SellCategory sellCategory) {
        this.SellCategory = sellCategory;
    }

    public AbClient getAbClient() {
        return abclient;
    }

    public String getHardDriveType() {
        return HardDriveType;
    }

    public void setHardDriveType(String hardDriveType) {
        HardDriveType = hardDriveType;
    }

}
