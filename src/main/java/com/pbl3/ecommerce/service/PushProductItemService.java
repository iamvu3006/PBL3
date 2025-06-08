package com.pbl3.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pbl3.ecommerce.dto.PushProductItemDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.AbVersion;
import com.pbl3.ecommerce.entity.Brand;
import com.pbl3.ecommerce.entity.Descripted;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.entity.SellCategory;
import com.pbl3.ecommerce.entity.TariffiPackage;
import com.pbl3.ecommerce.repository.AbClientRepository;
import com.pbl3.ecommerce.repository.BrandRepository;
import com.pbl3.ecommerce.repository.ProductItemRepository;
import com.pbl3.ecommerce.repository.SellCategoryRepository;
import com.pbl3.ecommerce.repository.TariffiPackageRepository;

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
    public ProductItem createProductItem(PushProductItemDTO dto) throws Exception {
        // Create and populate ProductItem entity
        ProductItem item = new ProductItem();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Lấy tên đăng nhập

        AbClient client = clientRepository.findByClientUseName(username)
                .orElseThrow(() -> new Exception("Không tìm thấy client với username: " + username));
        item.setAbclient(client);

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

        // Set sell category relationship with proper error handling
        SellCategory sc = sellCategoryRepository.findById(dto.getSellCategoryId())
                .orElseThrow(() -> new Exception("khong tim thay idsell tuong ung: " + dto.getSellCategoryId() + "tai id khach hang la" + item.getAbClient().getClientID()));
        item.setSellCategory(sc);

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
    
    
}

