package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.PushProductItemDTO;
import com.pbl3.ecommerce.dto.ProductItemResponseDTO;
import com.pbl3.ecommerce.entity.*;
import com.pbl3.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PushProductItemService {

    private final ProductItemRepository productItemRepository;
    private final AbClientRepository clientRepository;
    private final BrandRepository brandRepository;
    private final TariffiPackageRepository tariffiPackageRepository;
    private final SellCategoryRepository sellCategoryRepository;
    private final VersionRepository versionRepository; // FIX: Thêm repository cho Version

    @Autowired
    public PushProductItemService(
            ProductItemRepository productItemRepository,
            AbClientRepository clientRepository,
            BrandRepository brandRepository,
            TariffiPackageRepository tariffiPackageRepository,
            SellCategoryRepository sellCategoryRepository,
            VersionRepository versionRepository) { // FIX: Inject versionRepository
        this.productItemRepository = productItemRepository;
        this.clientRepository = clientRepository;
        this.brandRepository = brandRepository;
        this.tariffiPackageRepository = tariffiPackageRepository;
        this.sellCategoryRepository = sellCategoryRepository;
        this.versionRepository = versionRepository;
    }

    @Transactional
    public ProductItem createProductItem(PushProductItemDTO dto, String username) throws Exception {
        // Create and populate ProductItem entity
        ProductItem item = new ProductItem();

        // Find client
        AbClient client = clientRepository.findByClientUseName(username)
                .orElseThrow(() -> new Exception("Không tìm thấy client với username: " + username));
        item.setAbclient(client);

        // Find sell category
        SellCategory sc = sellCategoryRepository.findByClient(client);
        if (sc == null) {
            throw new Exception("User không có danh mục bán hàng. Vui lòng liên hệ admin");
        }
        item.setSellCategory(sc);

        // Set basic properties
        item.setPrice(dto.getPrice()); // FIX: Thêm dòng này
        item.setColor(dto.getColorName());
        item.setRam(dto.getProductRam());
        item.setInchs(dto.getInchs());
        item.setInternalmemory(dto.getInternalMemory());
        item.setHardDriveType(dto.getConfigurationHardDrive());
        item.setNormalDescribe(dto.getProductName()); // FIX: Nếu có field này trong DTO

        // Set product type with validation
        try {
            String type = dto.getProductType().trim().toUpperCase();
            if (type.equals("LAPTOP") || type.equals("PHONE")) {
                item.setProducttype(ProductItem.ProductType.valueOf(type));
            } else {
                throw new IllegalArgumentException("Loại sản phẩm không hợp lệ: " + type);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Loại sản phẩm phải là: LAPTOP hoặc PHONE.");
            throw e;
        }

        // Set brand relationship
        Brand brand = brandRepository.findByBrandName(dto.getBrandName());
        if (brand == null) {
            throw new Exception("Không tìm thấy brand_name: " + dto.getBrandName() + " tại id khách hàng là " + client.getClientID());
        }
        item.setBrand(brand);

        // FIX: Sử dụng repository thay vì truy cập trực tiếp collection
        AbVersion version = versionRepository.findByBrandAndVersionName(brand, dto.getVersion());
        if (version == null) {
            throw new Exception("Không tìm thấy phiên bản: " + dto.getVersion() + " tại khách hàng id " + client.getClientID());
        }
        // FIX: Thiếu setter cho version
        item.setVersion(version); // Cần thêm setter này trong ProductItem entity

        // Set tariff package
        TariffiPackage tp = tariffiPackageRepository.findByPackageName(dto.getTafiffPakageName());
        if (tp == null) {
            throw new Exception("Không tìm thấy gói cước: " + dto.getTafiffPakageName() + " tại id khách hàng là " + client.getClientID());
        }
        // FIX: Thiếu setter cho TariffiPackage
        item.setTariffiPackage(tp); // Cần thêm setter này trong ProductItem entity

        // Create and populate Descripted entity
        Descripted descripted = new Descripted();
        descripted.setProductName(dto.getProductName());
        descripted.setDescripted(dto.getDescriptedProduct());
        descripted.setAddress(dto.getAddress());
        descripted.setPrice(dto.getPrice());
        descripted.setWarrantyPeriod(dto.getWarranPeriod());

        // Set up relationship
        item.setDescriptedID(descripted);

        // Save the product item
        return productItemRepository.save(item);
    }

    // FIX: Improved DTO conversion with null safety
    public ProductItemResponseDTO convertToResponseDTO(ProductItem productItem) {
        if (productItem == null) {
            return null;
        }

        ProductItemResponseDTO dto = new ProductItemResponseDTO();

        // Basic fields
        dto.setProductItemId(productItem.getProductItemId());
        dto.setProductType(productItem.getProducttype() != null ? productItem.getProducttype().toString() : null);
        dto.setStatus(productItem.getStatus() != null ? productItem.getStatus().toString() : null);
        dto.setPrice(productItem.getPrice());
        dto.setColor(productItem.getColor());
        dto.setRam(productItem.getRam());
        dto.setInchs(productItem.getInchs());
        dto.setInternalMemory(productItem.getInternalMemory());
        dto.setHardDriveType(productItem.getHardDriveType());
        dto.setNormalDescribe(productItem.getNormalDescribe());

        // FIX: Safe access to client info
        AbClient client = productItem.getAbclient();
        if (client != null) {
            dto.setClientId(client.getClientID());
            dto.setClientUseName(client.getClientUseName());
            dto.setClientFullName(client.getClientFullName());
            dto.setClientPhoneNumber(client.getClientPhoneNumber());
        }

        // FIX: Safe access to brand info
        Brand brand = productItem.getBrandid();
        if (brand != null) {
            dto.setBrandId(brand.getBrandID());
            dto.setBrandName(brand.getBrandName());
        }

        // FIX: Safe access to version info
        AbVersion version = productItem.getVersion();
        if (version != null) {
            dto.setVersionId(version.getVersionID());
            dto.setVersionName(version.getVersionName());
        }

        // FIX: Safe access to tariff package info
        TariffiPackage tariffiPackage = productItem.getTariffiPackage();
        if (tariffiPackage != null) {
            dto.setTariffiPackageId(tariffiPackage.getTariffiPackageID());
            dto.setTariffiPackageName(tariffiPackage.getPackageName());
        }

        // FIX: Safe access to descripted info
        Descripted descripted = productItem.getDescripted();
        if (descripted != null) {
            dto.setProductName(descripted.getProductName());
            dto.setDescriptedProduct(descripted.getDescripted());
            dto.setAddress(descripted.getAddress());
            dto.setWarrantyPeriod(descripted.getWarrantyPeriod());
        }

        // FIX: Safe access to sell category info
        SellCategory sellCategory = productItem.getSellCategory();
        if (sellCategory != null) {
            dto.setSellCategoryId(sellCategory.getSellCategoryID());
        }

        return dto;
    }

    @Transactional
    public ProductItemResponseDTO createProductItemAndReturnDTO(PushProductItemDTO dto, String username) throws Exception {
        ProductItem savedItem = createProductItem(dto, username);
        return convertToResponseDTO(savedItem);
    }
}
