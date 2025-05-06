package com.pbl3.ecommerce.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductItemCategoryId implements Serializable {

    private Integer categoryID;
    private Integer productItemID;

    public ProductItemCategoryId() {}

    public ProductItemCategoryId(Integer categoryID, Integer productItemID) {
        this.categoryID = categoryID;
        this.productItemID = productItemID;
    }

    // Getters and setters

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getProductItemID() {
        return productItemID;
    }

    public void setProductItemID(Integer productItemID) {
        this.productItemID = productItemID;
    }

    // equals() and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductItemCategoryId that = (ProductItemCategoryId) o;

        if (!Objects.equals(categoryID, that.categoryID)) return false;
        return Objects.equals(productItemID, that.productItemID);
    }

    @Override
    public int hashCode() {
        int result = categoryID != null ? categoryID.hashCode() : 0;
        result = 31 * result + (productItemID != null ? productItemID.hashCode() : 0);
        return result;
    }
}
