package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.ListProductItemDTO;
import com.pbl3.ecommerce.dto.ProductItemDetailDTO;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.entity.ProductItem.Status;
import com.pbl3.ecommerce.repository.ListProductItemRepository;
import com.pbl3.ecommerce.repository.ProductItemDetailRepository;
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

    // Lấy tất cả sản phẩm đã được duyệt
    public List<ListProductItemDTO> getAllProducts() {
        List<ProductItem> items = listProductItemRepository.findByStatus(Status.APPROVED);
        List<ListProductItemDTO> result = new ArrayList<>();

        for (ProductItem item : items) {
            if (item != null) {
                result.add(new ListProductItemDTO(item));
            }
        }

        return result;
    }

    // Lấy sản phẩm đã duyệt theo categoryId
    public List<ListProductItemDTO> getProductItemsByCategoryId(Integer categoryId) {
        if (categoryId == null || categoryId <= 0) {
            throw new IllegalArgumentException("Category ID không hợp lệ");
        }

        List<ProductItem> items = listProductItemRepository.findApprovedByCategoryId(categoryId);
        List<ListProductItemDTO> result = new ArrayList<>();

        for (ProductItem item : items) {
            if (item != null) {
                result.add(new ListProductItemDTO(item));
            }
        }
        return result;
    }

    // Lấy chi tiết sản phẩm nếu sản phẩm đã được duyệt
    public ProductItemDetailDTO getProductItemDetailByProductId(Integer productId) {
        if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("ProductId không hợp lệ");
        }

        ProductItem item = productItemDetailRepository.findById(productId).orElse(null);

        if (item == null || item.getStatus() != Status.APPROVED) {
            throw new IllegalArgumentException("Sản phẩm không tồn tại hoặc chưa được duyệt");
        }

        return new ProductItemDetailDTO(item);
    }

    // Lọc sản phẩm đã được duyệt theo thương hiệu và khoảng giá
    public List<ListProductItemDTO> filterProducts(String brandName, Double minPrice, Double maxPrice) {
        List<ProductItem> items = listProductItemRepository.filterProducts(brandName, minPrice, maxPrice);
        List<ListProductItemDTO> result = new ArrayList<>();

        for (ProductItem item : items) {
            if (item != null) {
                result.add(new ListProductItemDTO(item));
            }
        }

        return result;
    }
}
