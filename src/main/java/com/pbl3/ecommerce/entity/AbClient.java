package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "abclient")
public class AbClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientID;

    @Column(unique = true)
    private String clientUseName;
    private String clientPassword;
    private String clientFullName;

    @Column(unique = true)
    private String clientPhoneNumber;

    @Column(unique = true)
    private String clientEmailAdress;

    private String clientAdress;

    // getters & setters

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

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

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
}