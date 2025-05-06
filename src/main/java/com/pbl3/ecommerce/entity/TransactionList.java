package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactionlist")
public class TransactionList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionID;

    @ManyToOne
    @JoinColumn(name = "ClientID")
    private AbClient client;

    private LocalDateTime transactionDay;
    private String transactionType;

    // Getters and setters

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public AbClient getClient() {
        return client;
    }

    public void setClient(AbClient client) {
        this.client = client;
    }

    public LocalDateTime getTransactionDay() {
        return transactionDay;
    }

    public void setTransactionDay(LocalDateTime transactionDay) {
        this.transactionDay = transactionDay;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
