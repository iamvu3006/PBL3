package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "tariffipackage")
public class TariffiPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tariffiPackageID;

    private String packageName;
    private Integer price;

    // Getters and setters

    public Integer getTariffiPackageID() {
        return tariffiPackageID;
    }

    public void setTariffiPackageID(Integer tariffiPackageID) {
        this.tariffiPackageID = tariffiPackageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
