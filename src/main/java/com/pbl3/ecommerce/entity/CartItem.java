package com.pbl3.ecommerce.entity;

public class CartItem {
    private Long productId;
    private String name;
    private Long price;
    private int quantity;

    public CartItem(Long productId, String name, Long price, int quantity) {
        this.productId  = productId;
        this.name       = name;
        this.price      = price;
        this.quantity   = quantity;
    }

    // --- getters & setters ---
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
