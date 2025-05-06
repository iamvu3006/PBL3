package com.pbl3.ecommerce.entity;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TransactionPackageId implements Serializable {

    private Integer transactionID;
    private Integer tariffiPackageID;

    public TransactionPackageId() {}

    public TransactionPackageId(Integer transactionID, Integer tariffiPackageID) {
        this.transactionID = transactionID;
        this.tariffiPackageID = tariffiPackageID;
    }

    // Getters and setters

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public Integer getTariffiPackageID() {
        return tariffiPackageID;
    }

    public void setTariffiPackageID(Integer tariffiPackageID) {
        this.tariffiPackageID = tariffiPackageID;
    }

    // equals() and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionPackageId that = (TransactionPackageId) o;

        if (!Objects.equals(transactionID, that.transactionID)) return false;
        return Objects.equals(tariffiPackageID, that.tariffiPackageID);
    }

    @Override
    public int hashCode() {
        int result = transactionID != null ? transactionID.hashCode() : 0;
        result = 31 * result + (tariffiPackageID != null ? tariffiPackageID.hashCode() : 0);
        return result;
    }
}
