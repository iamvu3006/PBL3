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

    @Autowired
    public PushProductItemService(
            ProductItemRepository productItemRepository,
            AbClientRepository clientRepository,
            BrandRepository brandRepository,
            TariffiPackageRepository tariffiPackageRepository,
            SellCategoryRepository sellCategoryRepository) {
        this.productItemRepository = productItemRepository;
        this.clientRepository = clientRepository;
        this.brandRepository = brandRepository;
        this.tariffiPackageRepository = tariffiPackageRepository;
        this.sellCategoryRepository = sellCategoryRepository;
    }

    @Transactional
    public ProductItem createProductItem(PushProductItemDTO dto, String username) throws Exception {
        // Create and populate ProductItem entity
        ProductItem item = new ProductItem();

        // Thay thế đoạn authentication bằng username từ tham số
        AbClient client = clientRepository.findByClientUseName(username)
                .orElseThrow(() -> new Exception("Không tìm thấy client với username: " + username));
        item.setAbclient(client);

        //Tim sellcategory cua nguoi dung hien tai
        SellCategory sc = sellCategoryRepository.findByClient(client);
        if (sc == null) {
            throw new Exception("User không có danh mục bán hàng. Vui lòng liên hệ admin");
        }
        item.setSellCategory(sc);
        // Set basic properties

        item.setColor(dto.getColorName());
        item.setRam(dto.getProductRam());
        item.setInchs(dto.getInchs());
        item.setInternalmemory(dto.getInternalMemory());
        item.setHardDriveType(dto.getConfigurationHardDrive());

        // Set product type with validation
        // Set product type with improved validation
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

        // Set brand relationship with proper error handling
        Brand brand = brandRepository.findByBrandName(dto.getBrandName());
        if (brand == null) {
            throw new Exception("Khong tim thay brand_name: " + dto.getBrandName() +" tai id khach hang la " + item.getAbClient().getClientID());
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
            throw new Exception("Khong tim thay phien ban:" + dto.getVersion() + "tai khach hang id" + item.getAbClient().getClientID());
        }

        // Set tariff package relationship with proper error handling
        TariffiPackage tp = tariffiPackageRepository.findByPackageName(dto.getTafiffPakageName());
        if (tp == null) {
            throw new Exception("khong tim thay goi cuoc: " + dto.getTafiffPakageName() + "tai id khach hang la" + item.getAbClient().getClientID());
        }

        // Create and populate Descripted entity
        Descripted descripted = new Descripted();
        descripted.setProductName(dto.getProductName());
        descripted.setDescripted(dto.getDescriptedProduct());
        descripted.setAddress(dto.getAddress());
        descripted.setPrice(dto.getPrice());
        descripted.setWarrantyPeriod(dto.getWarranPeriod());

        // Set up bidirectional relationship
        item.setDescriptedID(descripted); // This will also set the reverse relationship

        // Save the product item (Descripted will be saved via cascade)
        return productItemRepository.save(item);
    }

    // Thêm method để convert entity sang DTO trong service
    public ProductItemResponseDTO convertToResponseDTO(ProductItem productItem) {
        ProductItemResponseDTO dto = new ProductItemResponseDTO();

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

        // Client info
        if (productItem.getAbclient() != null) {
            dto.setClientId(productItem.getAbclient().getClientID());
            dto.setClientUseName(productItem.getAbclient().getClientUseName());
            dto.setClientFullName(productItem.getAbclient().getClientFullName());
            dto.setClientPhoneNumber(productItem.getAbclient().getClientPhoneNumber());
        }

        // Brand info
        if (productItem.getBrandid() != null) {
            dto.setBrandId(productItem.getBrandid().getBrandID());
            dto.setBrandName(productItem.getBrandid().getBrandName());
        }

        // Version info
        if (productItem.getVersion() != null) {
            dto.setVersionId(productItem.getVersion().getVersionID());
            dto.setVersionName(productItem.getVersion().getVersionName());
        }

        // Tariff Package info
        if (productItem.getTariffiPackage() != null) {
            dto.setTariffiPackageId(productItem.getTariffiPackage().getTariffiPackageID());
            dto.setTariffiPackageName(productItem.getTariffiPackage().getPackageName());
        }

        // Descripted info
        if (productItem.getDescripted() != null) {
            dto.setProductName(productItem.getDescripted().getProductName());
            dto.setDescriptedProduct(productItem.getDescripted().getDescripted());
            dto.setAddress(productItem.getDescripted().getAddress());
            dto.setWarrantyPeriod(productItem.getDescripted().getWarrantyPeriod());
        }

        // SellCategory info
        if (productItem.getSellCategory() != null) {
            dto.setSellCategoryId(productItem.getSellCategory().getSellCategoryID());
        }

        return dto;
    }

    // Method để tạo và trả về DTO thay vì entity
    @Transactional
    public ProductItemResponseDTO createProductItemAndReturnDTO(PushProductItemDTO dto, String username) throws Exception {
        ProductItem savedItem = createProductItem(dto, username);
        return convertToResponseDTO(savedItem);
    }
}
