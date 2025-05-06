package com.pbl3.ecommerce.entity;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WishListProductId implements Serializable {

    private Integer wishListID;
    private Integer productItemID;

    public WishListProductId() {}

    public WishListProductId(Integer wishListID, Integer productItemID) {
        this.wishListID = wishListID;
        this.productItemID = productItemID;
    }

    public Integer getWishListID() {
        return wishListID;
    }

    public void setWishListID(Integer wishListID) {
        this.wishListID = wishListID;
    }

    public Integer getProductItemID() {
        return productItemID;
    }

    public void setProductItemID(Integer productItemID) {
        this.productItemID = productItemID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishListProductId)) return false;
        WishListProductId that = (WishListProductId) o;
        return Objects.equals(wishListID, that.wishListID) &&
                Objects.equals(productItemID, that.productItemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishListID, productItemID);
    }
}
