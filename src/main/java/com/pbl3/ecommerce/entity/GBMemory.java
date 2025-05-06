package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "gbmemory")
public class GBMemory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gbMemoryID;
    private Integer ram;
    private Integer rom;
    private Integer internalMemory;

    @OneToMany(mappedBy = "gbMemory")
    private List<Configuration> configurations;

    // getters & setters
    public Integer getGbMemoryID() {
        return gbMemoryID;
    }

    public void setGbMemoryID(Integer gbMemoryID) {
        this.gbMemoryID = gbMemoryID;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getRom() {
        return rom;
    }

    public void setRom(Integer rom) {
        this.rom = rom;
    }

    public Integer getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(Integer internalMemory) {
        this.internalMemory = internalMemory;
    }

    public List<Configuration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<Configuration> configurations) {
        this.configurations = configurations;
    }
}