package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "productitem")
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productItemID;

    @Enumerated(EnumType.STRING)
    @Column(name = "producttype")
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

    public void setAbClient(AbClient abClient) {
        this.abclient = abClient;
    }
}
