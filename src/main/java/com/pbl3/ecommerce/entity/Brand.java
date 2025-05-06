package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandID;
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private List<AbVersion> versions;

    // getters & setters

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<AbVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<AbVersion> versions) {
        this.versions = versions;
    }
}
