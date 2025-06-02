package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ProductCategoryClient> productCategoryClients = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "wishlistid")
    private WishListCategory wishListCategory;

    // getters & setters

    public WishListCategory getWishListCategory() {
        return wishListCategory;
    }

    public void setWishListCategory(WishListCategory wishListCategory) {
        if(wishListCategory == null){
            if(this.wishListCategory != null)
                this.wishListCategory.setAbClient(null); //ngat ket noi tu wishlist toi client neu wishlist khong con ton tai nua
        } else {
            wishListCategory.setAbClient(this);     //dam bao wishlist co the tham chieu nguoc lai

            if(this.wishListCategory != null && this.wishListCategory != wishListCategory) //trong truong hop client da co wishlish khac
                this.wishListCategory.setAbClient(null); //ngat ket noi voi wishlist cu
        }
        this.wishListCategory = wishListCategory;
    }

    public List<ProductCategoryClient> getProductCategoryClients() {
        return productCategoryClients;
    }

    public void setProductCategoryClients(List<ProductCategoryClient> productCategoryClients) {
        this.productCategoryClients = productCategoryClients;
    }

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
