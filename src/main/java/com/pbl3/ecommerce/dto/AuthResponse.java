package com.pbl3.ecommerce.dto;

public class AuthResponse {
    private boolean success;
    private String message;
    private Integer clientId;
    private String username;
     private String role;   

    // Constructors
    public AuthResponse() {
    }

    public AuthResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public AuthResponse(boolean success, String message, Integer clientId, String username) {
        this.success = success;
        this.message = message;
        this.clientId = clientId;
        this.username = username;
    }
    public AuthResponse(boolean success,
                        String message,
                        Integer clientId,
                        String username,
                        String role) {
        this.success = success;
        this.message = message;
        this.clientId = clientId;
        this.username = username;
        this.role = role;
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

    public String getEmail() {
        return "";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}