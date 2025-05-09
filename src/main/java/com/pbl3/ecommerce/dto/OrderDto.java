package com.pbl3.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private String fullName;
    private String address;
    private String phone;
    private List<OrderItemDto> cartItems = new ArrayList<>();

    public OrderDto() {}

    // Getters / Setters
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderItemDto> getCartItems() {
        return cartItems;
    }
    public void setCartItems(List<OrderItemDto> cartItems) {
        this.cartItems = cartItems;
    }
}
