package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.ProductItemDTO;
import com.pbl3.ecommerce.entity.*;
import com.pbl3.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductItemService {

    private final ProductItemRepository productItemRepository;
    private final AbClientRepository clientRepository;
    private final BrandRepository brandRepository;
    private final TariffiPackageRepository tariffiPackageRepository;
    private final SellCategoryRepository sellCategoryRepository;
    private final ProductItemSellRepository productItemSellRepository;

    @Autowired
    public ProductItemService(
            ProductItemRepository productItemRepository,
            AbClientRepository clientRepository,
            BrandRepository brandRepository,
            TariffiPackageRepository tariffiPackageRepository,
            SellCategoryRepository sellCategoryRepository,
            ProductItemSellRepository productItemSellRepository) {
        this.productItemRepository = productItemRepository;
        this.clientRepository = clientRepository;
        this.brandRepository = brandRepository;
        this.tariffiPackageRepository = tariffiPackageRepository;
        this.sellCategoryRepository = sellCategoryRepository;
        this.productItemSellRepository = productItemSellRepository;
    }

    @Transactional
    public ProductItem createProductItem(ProductItemDTO dto) throws Exception {
        // Validate required fields
        if (dto.getProductName() == null || dto.getProductName().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sản phẩm không được để trống");
        }
        if (dto.getPrice() == null || dto.getPrice() <= 0) {
            throw new IllegalArgumentException("Giá sản phẩm phải lớn hơn 0");
        }
        if (dto.getAddress() == null || dto.getAddress().trim().isEmpty()) {
            throw new IllegalArgumentException("Địa chỉ không được để trống");
        }
        if (dto.getBrandName() == null || dto.getBrandName().trim().isEmpty()) {
            throw new IllegalArgumentException("Thương hiệu không được để trống");
        }
        if (dto.getVersion() == null || dto.getVersion().trim().isEmpty()) {
            throw new IllegalArgumentException("Phiên bản không được để trống");
        }
        if (dto.getSellCategoryId() == null) {
            throw new IllegalArgumentException("Danh mục không được để trống");
        }
        if (dto.getClientId() == null) {
            throw new IllegalArgumentException("ID khách hàng không được để trống");
        }

        ProductItem item = new ProductItem();

        // Set basic properties
        item.setColor(dto.getColorName());
        item.setRam(dto.getProductRam());
        item.setInchs(dto.getInchs());
        item.setInternalmemory(dto.getInternalMemory());
        item.setHardDriveType(dto.getConfigurationHardDrive());

        // Set product type with validation
        try {
            String type = dto.getProductType() != null ? dto.getProductType().trim().toUpperCase() : "PHONE";
            if (type.equals("LAPTOP") || type.equals("PHONE")) {
                item.setProducttype(ProductItem.ProductType.valueOf(type));
            } else {
                throw new IllegalArgumentException("Loại sản phẩm không hợp lệ: " + type);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Loại sản phẩm phải là: LAPTOP hoặc PHONE.");
            throw e;
        }

        // Set client relationship with proper error handling
        AbClient client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new Exception("Không tìm thấy khách hàng với ID: " + dto.getClientId()));
        item.setAbClient(client);

        // Set brand relationship with proper error handling
        Brand brand = brandRepository.findByBrandName(dto.getBrandName());
        if (brand == null) {
            throw new Exception("Không tìm thấy thương hiệu: " + dto.getBrandName());
        }
        item.setBrand(brand);

        AbVersion Version = null;
        for(AbVersion v : brand.getVersions()){
            if(v.getVersionName().equalsIgnoreCase(dto.getVersion())){
                Version = v;
                break;
            }
        }
        if(Version == null) {
            throw new Exception("Không tìm thấy phiên bản: " + dto.getVersion());
        }

        // Set tariff package relationship with proper error handling
        TariffiPackage tp = tariffiPackageRepository.findByPackageName(dto.getTafiffPakageName());
        if (tp == null) {
            throw new Exception("Không tìm thấy gói cước: " + dto.getTafiffPakageName());
        }
        item.setTariffiPackage(tp);

        // Set sell category relationship with proper error handling
        SellCategory sc = sellCategoryRepository.findById(dto.getSellCategoryId())
                .orElseThrow(() -> new Exception("Không tìm thấy danh mục với ID: " + dto.getSellCategoryId()));
        item.setSellCategory(sc);

        // Create and populate Descripted entity
        Descripted descripted = new Descripted();
        descripted.setProductName(dto.getProductName());
        descripted.setDescripted(dto.getDescriptedProduct());
        descripted.setAddress(dto.getAddress());
        descripted.setPrice(dto.getPrice());
        descripted.setWarrantyPeriod(dto.getWarranPeriod());

        // Set up bidirectional relationship
        item.setDescriptedID(descripted);

        // Save the product item (Descripted will be saved via cascade)
        return productItemRepository.save(item);
    }

    public List<ProductItemDTO> ListProductBySellID(Integer clientID) {
        List<ProductItem> items = productItemSellRepository.findBySellCategoryIDNative(clientID);
        List<ProductItemDTO> itemDTOList = new ArrayList<>();
        for (ProductItem item : items) {
            ProductItemDTO productItemDTO = new ProductItemDTO(item);
            itemDTOList.add(productItemDTO);
        }
        return itemDTOList;
    }
} 