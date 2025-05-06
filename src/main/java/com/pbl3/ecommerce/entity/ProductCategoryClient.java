package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "productcategoryclient")
public class ProductCategoryClient {
    @EmbeddedId
    private ProductCategoryClientId id;

    @ManyToOne
    @MapsId("categoryID")
    @JoinColumn(name = "categoryID")
    private ProductCategory category;

    @ManyToOne
    @MapsId("clientID")
    @JoinColumn(name = "clientID")
    private AbClient client;

    // getters & setters

    public ProductCategoryClientId getId() {
        return id;
    }

    public void setId(ProductCategoryClientId id) {
        this.id = id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public AbClient getClient() {
        return client;
    }

    public void setClient(AbClient client) {
        this.client = client;
    }
}