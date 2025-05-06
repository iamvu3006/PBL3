package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "wishlistcategory")
public class WishListCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishListID;

    @ManyToOne
    @JoinColumn(name = "ClientID")
    private AbClient client;

    // Getters and setters

    public Integer getWishListID() {
        return wishListID;
    }

    public void setWishListID(Integer wishListID) {
        this.wishListID = wishListID;
    }

    public AbClient getClient() {
        return client;
    }

    public void setClient(AbClient client) {
        this.client = client;
    }
}
