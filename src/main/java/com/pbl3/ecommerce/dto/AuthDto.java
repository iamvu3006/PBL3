package com.pbl3.ecommerce.dto;

import com.pbl3.ecommerce.entity.AbClient;

public class AuthDto {
    // Common fields
    private boolean success;
    private String message;

    // Client fields
    private Integer clientId;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;

    // Constructors

    // For successful authentication response
    public AuthDto(boolean success, String message, Integer clientId, String username,
                   String fullName, String phoneNumber, String email, String address) {
        this.success = success;
        this.message = message;
        this.clientId = clientId;
        this.username = username;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // For error response
    public AuthDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // For login request
    public AuthDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // For registration request
    public AuthDto(String username, String password, String fullName,
                   String phoneNumber, String email, String address) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public AuthDto(boolean success, String message, Integer clientId, String username) {
        this.success = success;
        this.message = message;
        this.clientId = clientId;
        this.username = username;
    }
    public AuthDto(boolean success, String message, Integer clientID, String clientUseName, Object o, String clientPhoneNumber, String clientEmailAdress, String clientAdress) {
    }

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Helper method to convert to AbClient entity
    public AbClient toAbClientEntity() {
        AbClient client = new AbClient();
        client.setClientUseName(this.username);
        client.setClientPassword(this.password); // Note: Password should be encoded before setting
        client.setClientFullName(this.fullName);
        client.setClientPhoneNumber(this.phoneNumber);
        client.setClientEmailAdress(this.email);
        client.setClientAdress(this.address);
        return client;
    }
}