package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.AbClientDTO;
import com.pbl3.ecommerce.dto.ProductItemDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.entity.WishListCategory;
import com.pbl3.ecommerce.repository.AbClientRepository;
import com.pbl3.ecommerce.repository.ProductItemRepository;
import com.pbl3.ecommerce.repository.WishListCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AbClientRepository abClientRepository;

    @Autowired
    private WishListCategoryRepository wishListCategoryRepository;

    public List<AbClientDTO> getAllClients() {
        List<AbClient> clients = abClientRepository.findAll();
        List<AbClientDTO> dtos = new ArrayList<>();
        for (AbClient client : clients) {
            AbClientDTO dto = new AbClientDTO();
            dto.setId(client.getClientID());
            dto.setUsername(client.getClientUseName());
            dto.setFullName(client.getClientFullName());
            dto.setEmail(client.getClientEmailAdress());
            dto.setAddress(client.getClientAdress());
            dtos.add(dto);
        }
        return dtos;
    }

    public void deleteUser(Integer id) {
        abClientRepository.deleteById(id);
    }

    public AbClient addClient(AbClient client) {
        WishListCategory defaultCategory = new WishListCategory();
        defaultCategory = wishListCategoryRepository.save(defaultCategory);
        client.setWishListCategory(defaultCategory);
        return abClientRepository.save(client);
    }

    @Autowired
    private ProductItemRepository productItemRepository;
    public List<ProductItemDTO> getProductItemsByStatus(ProductItem.Status status) {
        List<ProductItem> products = productItemRepository.findByStatus(status);
        List<ProductItemDTO> dtos = new ArrayList<>();

        for (ProductItem product : products) {
            ProductItemDTO dto = new ProductItemDTO();
            dto.setPrice(product.getPrice());
            dto.setColorName(product.getColor());
            dto.setBrandName(product.getBrand().getBrandName());
            dto.setVersion(product.getVersion().getVersionName());
            dto.setProductRam(product.getRam());
            dto.setProductType(product.getProducttype().toString());
            dto.setConfigurationHardDrive(product.getHardDriveType());
            dto.setDescripted(product.getDescripted().getDescripted());
            dto.setNormalDescribe(product.getNormalDescribe());
            dto.setInternalMemory(product.getInternalMemory());
            dto.setTafiffPakageName(product.getTariffiPackage().getPackageName());
            dtos.add(dto);
        }

        return dtos;
    }


    public void approveProduct(Integer id) {
        ProductItem product = productItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStatus(ProductItem.Status.APPROVED);
        productItemRepository.save(product);
    }

    public void rejectProduct(Integer id) {
        ProductItem product = productItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStatus(ProductItem.Status.REJECTED);
        productItemRepository.save(product);
    }

    public void addProduct(ProductItem productItem) {
        productItem.setStatus(ProductItem.Status.PENDING); // An toàn, đảm bảo đúng
        productItemRepository.save(productItem);
    }

    private ProductItemDTO toDTO(ProductItem product) {
        ProductItemDTO dto = new ProductItemDTO();
        dto.setPrice(product.getPrice());
        dto.setColorName(product.getColor());
        dto.setBrandName(product.getBrand().getBrandName());
        dto.setVersion(product.getVersion().getVersionName());
        dto.setProductRam(product.getRam());
        dto.setProductType(product.getProducttype().toString());
        dto.setConfigurationHardDrive(product.getHardDriveType());
        dto.setDescripted(product.getDescripted().getDescripted());
        dto.setNormalDescribe(product.getNormalDescribe());
        dto.setInternalMemory(product.getInternalMemory());
        dto.setTafiffPakageName(product.getTariffiPackage().getPackageName());
        return dto;
    }
}
