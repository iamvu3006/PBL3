package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "productitemcategory")
public class ProductItemCategory {

    @EmbeddedId
    private ProductItemCategoryId id;

    @ManyToOne
    @MapsId("categoryID")
    @JoinColumn(name = "CategoryID")
    private ProductCategory category;

    @ManyToOne
    @MapsId("productItemID")
    @JoinColumn(name = "ProductItemID")
    private ProductItem productItem;

    // Getters and setters

    public ProductItemCategoryId getId() {
        return id;
    }

    public void setId(ProductItemCategoryId id) {
        this.id = id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }
}
