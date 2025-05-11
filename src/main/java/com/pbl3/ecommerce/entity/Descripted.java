package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Descripted")
public class Descripted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "descriptionid")
    private Integer descriptionID;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "Price")
    private Integer Price;

    @Column(name = "Address")
    private String Address;

    @Column(name = "warranty_period")
    private Integer warrantyPeriod;

    @Column(name = "descipted")
    private String Descripted;

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
        return Price;
    }

    public void setPrice(Integer price) {
        this.Price = price;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public Integer getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Integer warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getDescripted() {
        return Descripted;
    }
    public void setDescripted(String descripted) {
        this.Descripted = descripted;
    }


}
