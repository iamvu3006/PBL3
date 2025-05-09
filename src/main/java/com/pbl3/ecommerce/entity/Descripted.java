package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "descripted")
public class Descripted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer descriptionID;
    private String productName;
    private Integer price;
    private String address;
    private Integer warrantyPeriod;

    @Column(columnDefinition = "TEXT")
    private String descripted;

    @ManyToOne
    @JoinColumn(name = "productItemID")
    private ProductItem productItem;

    // getters & setters

    public Integer getDescriptionID() {
        return descriptionID;
    }

    public void setDescriptionID(Integer descriptionID) {
        this.descriptionID = descriptionID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public String getDescripted() {
        return descripted;
    }

    public void setDescripted(String descripted) {
        this.descripted = descripted;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }
}