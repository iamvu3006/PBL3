package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.ListProductItemDTO;
import com.pbl3.ecommerce.dto.ProductItemDetailDTO;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.repository.ListProductItemRepository;
import com.pbl3.ecommerce.repository.ProductItemDetailRepository;
import com.pbl3.ecommerce.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListProductService {

    @Autowired
    private ListProductItemRepository listProductItemRepository;

    @Autowired
    private ProductItemDetailRepository productItemDetailRepository;
    // Lấy tất cả sản phẩm
    public List<ListProductItemDTO> getAllProducts() {
        List<ProductItem> items = listProductItemRepository.findAll();
        List<ListProductItemDTO> result = new ArrayList<>();

        for (ProductItem item : items) {
            if (item != null) {
                ListProductItemDTO dto = new ListProductItemDTO(item);
                result.add(dto);
            }
        }

        return result;
    }

    // Lấy sản phẩm theo categoryId
    public List<ListProductItemDTO> getProductItemsByCategoryId(Integer categoryId) {
        if (categoryId == null || categoryId <= 0) {
            throw new IllegalArgumentException("Category ID không hợp lệ");
        }

        List<ProductItem> items = listProductItemRepository.findByCategoryId(categoryId);
        List<ListProductItemDTO> result = new ArrayList<>();

        for (ProductItem item : items) {
            if (item != null) {
               ListProductItemDTO dto = new ListProductItemDTO(item);
                result.add(dto);
            }
        }
        return result;
    }

    public ProductItemDetailDTO getProductItemDetailByProductId(Integer productId){
        if(productId == null || productId <= 0)
        {
            throw new IllegalArgumentException("ProductId khong hop le");
        }
        ProductItem item = productItemDetailRepository.findById(productId).orElse(null);

        if(item == null){
            throw new IllegalArgumentException("Khong tim thay chi tiet san pham tai product co id " + productId);
        }
        return new ProductItemDetailDTO(item);
    }
}
