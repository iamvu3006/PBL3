package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name = "productitem")
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productItemID;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "pproducttype")
    private ProductType producttype;

    public ProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    @ManyToOne
    @JoinColumn(name = "clientid")
    private AbClient abclient;

    @JoinColumn(name = "Color")
    private String Color;

    @JoinColumn(name = "ram")
    private Integer Ram;

    @JoinColumn(name = "inchs")
    private String Inchs;

    @JoinColumn(name = "internalmemory")
    private Integer InternalMemory;

    @JoinColumn(name = "harddrivetype")
    private String HardDriveType;

    @OneToMany(mappedBy = "productItem")
    private List<Descripted> descripteds;

    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand Brandid;

    @ManyToOne
    @JoinColumn(name = "tariffi_packageid")
    private TariffiPackage TariffiPackage;

    @ManyToOne
    @JoinColumn(name = "sell_categoryid")
    private SellCategory SellCategory;


    // Getters & Setters
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

    public void setBrand(Brand brand) {
        this.Brandid = brand;
    }

    public enum ProductType{
        Laptop, Phone
    }
    public Integer getProductItemID() {
        return productItemID;
    }

    private void setProductItemID(Integer productItemID) {
        this.productItemID = productItemID;
    }

    public TariffiPackage getTariffiPackage() {
        return TariffiPackage;
    }

    public void setTariffiPackage(TariffiPackage tariffiPackage) {
        this.TariffiPackage = tariffiPackage;
    }

    public SellCategory getSellCategory() {
        return SellCategory;
    }

    private void setSellCategory(SellCategory sellCategory) {
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

    private void setAbClient(AbClient abClient) {
        this.abclient = abClient;
    }
    public List<Descripted> getDescripteds() {
        return descripteds;
    }

    public void setDescripteds(List<Descripted> descripteds) {
        this.descripteds = descripteds;
    }
}
