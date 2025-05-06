package com.pbl3.ecommerce.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductCategoryClientId implements Serializable {

    private Integer categoryID;
    private Integer clientID;

    public ProductCategoryClientId() {}

    public ProductCategoryClientId(Integer categoryID, Integer clientID) {
        this.categoryID = categoryID;
        this.clientID = clientID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCategoryClientId)) return false;
        ProductCategoryClientId that = (ProductCategoryClientId) o;
        return Objects.equals(getCategoryID(), that.getCategoryID()) &&
                Objects.equals(getClientID(), that.getClientID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryID(), getClientID());
    }
}
