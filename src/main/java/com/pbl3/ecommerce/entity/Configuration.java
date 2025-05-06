package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "configuration")
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer configurationID;

    @Enumerated(EnumType.STRING)
    private HardDriveType hardDrive;

    private Double inchs;

    @ManyToOne
    @JoinColumn(name = "gbMemoryID")
    private GBMemory gbMemory;

    public enum HardDriveType {
        SSD, HDD
    }

    // getters & setters
    public Integer getConfigurationID() {
        return configurationID;
    }

    public void setConfigurationID(Integer configurationID) {
        this.configurationID = configurationID;
    }

    public HardDriveType getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDriveType hardDrive) {
        this.hardDrive = hardDrive;
    }

    public Double getInchs() {
        return inchs;
    }

    public void setInchs(Double inchs) {
        this.inchs = inchs;
    }

    public GBMemory getGbMemory() {
        return gbMemory;
    }

    public void setGbMemory(GBMemory gbMemory) {
        this.gbMemory = gbMemory;
    }
}
