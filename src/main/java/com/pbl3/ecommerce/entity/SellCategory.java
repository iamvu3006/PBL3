package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "sellcategory")
public class SellCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sellCategoryID;

    @ManyToOne
    @JoinColumn(name = "ClientID")
    private AbClient client;

    // Getters and setters

    public Integer getSellCategoryID() {
        return sellCategoryID;
    }

    public void setSellCategoryID(Integer sellCategoryID) {
        this.sellCategoryID = sellCategoryID;
    }

    public AbClient getClient() {
        return client;
    }

    public void setClient(AbClient client) {
        this.client = client;
    }
}
