package com.pbl3.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.PENDING;

    @ManyToOne
    @JoinColumn(name = "clientid")
    @JsonIgnore
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
    @JsonIgnore
    private AbVersion version;

    @ManyToOne
    @JoinColumn(name = "brand")
    @JsonIgnore
    private Brand Brandid;

    @ManyToOne
    @JoinColumn(name = "tariffi_packageid")
    @JsonIgnore
    private TariffiPackage TariffiPackage;

    @ManyToOne
    @JoinColumn(name = "sell_categoryid")
    @JsonIgnore
    private SellCategory SellCategory;

    @OneToOne(cascade = CascadeType.PERSIST) //Luu du luu cua descripted roi moi luu productitem
    @JoinColumn(name = "describeid")
    private Descripted descripted;

    @OneToMany(mappedBy = "productItem")
    @JsonIgnore
    private List<ProductItemCategory> productItemCategories = new ArrayList<>();

    // Getters & Setters

    public enum Status{
        PENDING,
        APPROVED,
        REJECTED
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

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

    public void setVersion(AbVersion version) {
        this.version = version;
    }

    public void setTariffiPackage(TariffiPackage tariffiPackage) {
        TariffiPackage = tariffiPackage;
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

    public enum ProductType {
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

    public void setAbclient(AbClient abclient) {
        this.abclient = abclient;
    }
}
