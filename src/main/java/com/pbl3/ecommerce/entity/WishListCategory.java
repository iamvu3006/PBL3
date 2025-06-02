package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "wishlistcategory")
public class WishListCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishListID;

    @OneToOne(mappedBy = "wishListCategory", optional = false)
    private AbClient abClient;
    // Getters and setters

    public Integer getWishListID() {
        return wishListID;
    }

    public void setWishListID(Integer wishListID) {
        this.wishListID = wishListID;
    }

    public AbClient getAbClient() {
        return abClient;
    }

    public void setAbClient(AbClient abClient) {
        if(this.abClient != abClient)
            this.abClient = abClient;
    }
}
