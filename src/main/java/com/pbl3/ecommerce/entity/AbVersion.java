package com.pbl3.ecommerce.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "abversion")
public class AbVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer versionID;
    private String versionName;

    @ManyToOne
    @JoinColumn(name = "brandid")
    @JsonBackReference
    private Brand brand;

    // getters & setters


    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
