package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "transactionpackage")
public class TransactionPackage {

    @EmbeddedId
    private TransactionPackageId id;

    @ManyToOne
    @MapsId("transactionID")
    @JoinColumn(name = "TransactionID")
    private TransactionList transaction;

    @ManyToOne
    @MapsId("tariffiPackageID")
    @JoinColumn(name = "TariffiPackageID")
    private TariffiPackage tariffiPackage;

    // Getters and setters

    public TransactionPackageId getId() {
        return id;
    }

    public void setId(TransactionPackageId id) {
        this.id = id;
    }

    public TransactionList getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionList transaction) {
        this.transaction = transaction;
    }

    public TariffiPackage getTariffiPackage() {
        return tariffiPackage;
    }

    public void setTariffiPackage(TariffiPackage tariffiPackage) {
        this.tariffiPackage = tariffiPackage;
    }
}
