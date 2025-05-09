package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.entity.Descripted;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.repository.DescriptedRepository;
import com.pbl3.ecommerce.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private DescriptedRepository descriptedRepository;

    public List<Map<String, Object>> getAllProductDisplayData() {
        List<ProductItem> items = productItemRepository.findAll();
        List<Map<String, Object>> result = new ArrayList<>();

        for (ProductItem item : items) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", item.getProductItemID());
            data.put("brand", item.getBrand().getBrandName());
            data.put("color", item.getColor().getColorName());
            data.put("configuration", item.getConfiguration());
            data.put("package", item.getTariffiPackage().getPackageName());

            List<Descripted> descriptions = descriptedRepository.findByProductItem(item);
            if (!descriptions.isEmpty()) {
                Descripted desc = descriptions.get(0);
                data.put("name", desc.getProductName());
                data.put("price", desc.getPrice());
                data.put("description", desc.getDescripted());
            }

            result.add(data);
        }
        return result;
    }
    public List<ProductItem> searchProducts(String keyword) {
        return productItemRepository.searchByProductName(keyword);
    }
}
