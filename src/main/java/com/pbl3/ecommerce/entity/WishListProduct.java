package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "wishlistproduct")
public class WishListProduct {

    @EmbeddedId
    private WishListProductId id;

    @ManyToOne
    @MapsId("wishListID")
    @JoinColumn(name = "WishListID")
    private WishListCategory wishListCategory;

    @ManyToOne
    @MapsId("productItemID")
    @JoinColumn(name = "ProductItemID")
    private ProductItem productItem;

    public WishListProduct() {}

    public WishListProduct(WishListCategory wishListCategory, ProductItem productItem) {
        this.wishListCategory = wishListCategory;
        this.productItem = productItem;
        this.id = new WishListProductId(wishListCategory.getWishListID(), productItem.getProductItemID());
    }

    public WishListProductId getId() {
        return id;
    }

    public void setId(WishListProductId id) {
        this.id = id;
    }

    public WishListCategory getWishListCategory() {
        return wishListCategory;
    }

    public void setWishListCategory(WishListCategory wishListCategory) {
        this.wishListCategory = wishListCategory;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }
}
