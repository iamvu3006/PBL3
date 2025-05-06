package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "descripted")
public class Descripted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer descriptionID;
    private String productName;
    private Integer price;
    private String address;
    private Integer warrantyPeriod;

    @Column(columnDefinition = "TEXT")
    private String descripted;

    @ManyToOne
    @JoinColumn(name = "productItemID")
    private ProductItem productItem;

    // getters & setters
}