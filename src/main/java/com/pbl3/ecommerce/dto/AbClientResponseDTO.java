package com.pbl3.ecommerce.dto;

import java.util.List;

public class AbClientResponseDTO {
    private Integer clientID;
    private String clientUseName;
    private String clientFullName;
    private String role;
    private String clientPhoneNumber;
    private String clientEmailAdress;
    private String clientAdress;
    private Integer sellCategoryId;
    private Integer wishListCategoryId;
    private List<Integer> productItemIds; // Chỉ lưu ID thay vì toàn bộ object

    // Constructors
    public AbClientResponseDTO() {}

    // Getters and Setters
    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getClientUseName() {
        return clientUseName;
    }

    public void setClientUseName(String clientUseName) {
        this.clientUseName = clientUseName;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientEmailAdress() {
        return clientEmailAdress;
    }

    public void setClientEmailAdress(String clientEmailAdress) {
        this.clientEmailAdress = clientEmailAdress;
    }

    public String getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public Integer getSellCategoryId() {
        return sellCategoryId;
    }

    public void setSellCategoryId(Integer sellCategoryId) {
        this.sellCategoryId = sellCategoryId;
    }

    public Integer getWishListCategoryId() {
        return wishListCategoryId;
    }

    public void setWishListCategoryId(Integer wishListCategoryId) {
        this.wishListCategoryId = wishListCategoryId;
    }

    public List<Integer> getProductItemIds() {
        return productItemIds;
    }

    public void setProductItemIds(List<Integer> productItemIds) {
        this.productItemIds = productItemIds;
    }
}