package com.pbl3.ecommerce.dto;

public class ClientDTO {
     private Integer id; 
    private String clientFullName;
    private String clientPhoneNumber;
    private String clientEmailAdress;
    private String clientAdress;
    private String currentPassword; // Chỉ dùng cho update

    // Constructors
    public ClientDTO() {}

    public ClientDTO(String clientFullName, String clientPhoneNumber, String clientEmailAdress, String clientAdress) {
        this.clientFullName = clientFullName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmailAdress = clientEmailAdress;
        this.clientAdress = clientAdress;
    }
     public ClientDTO(Integer id,
                     String clientFullName,
                     String clientPhoneNumber,
                     String clientEmailAdress,
                     String clientAdress) {
        this.id = id;
        this.clientFullName = clientFullName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmailAdress = clientEmailAdress;
        this.clientAdress = clientAdress;
    }
     public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    // Getters & Setters
    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
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

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
} 