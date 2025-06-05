package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.ListProductItemDTO;
import com.pbl3.ecommerce.entity.WishListCategory;
import com.pbl3.ecommerce.entity.WishListProduct;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.repository.WishListCategoryRepository;
import com.pbl3.ecommerce.repository.WishListProductRepository;
import com.pbl3.ecommerce.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishListProductService {

    @Autowired
    private WishListProductRepository wishListProductRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private WishListCategoryRepository wishListCategoryRepository;

    public String addProductToWishList(Integer wishListId, Integer productId) {
        if (wishListProductRepository.existsByWishListCategory_wishListIDAndProductItem_ProductItemId(wishListId, productId)) {
            return "Sản phẩm đã có trong danh sách yêu thích";
        }

        Optional<WishListCategory> wishList = wishListCategoryRepository.findById(wishListId);
        Optional<ProductItem> product = productItemRepository.findById(productId);

        if (wishList.isEmpty() || product.isEmpty()) {
            return "Không tìm thấy wishlist hoặc sản phẩm";
        }

        WishListProduct newEntry = new WishListProduct(wishList.get(), product.get());
        wishListProductRepository.save(newEntry);
        return "Đã thêm vào danh sách yêu thích";
    }

    public String RemoveProductFormWishList(Integer wishListId, Integer productId){
        wishListProductRepository.deleteByWishListCategory_wishListIDAndProductItem_ProductItemId(wishListId, productId);
        return "Da xoa san pham khoi danh sach danh sach yeu thich";
    }

    public List<ListProductItemDTO> getListWishProduct(Integer clientId){
        List<WishListProduct> wishListProducts = wishListProductRepository.findByWishListCategory_abClient_clientID(clientId);
        List<ListProductItemDTO> res = new ArrayList<>();
        for(WishListProduct wishListProduct : wishListProducts)
        {
            ProductItem item = wishListProduct.getProductItem();
            res.add(new ListProductItemDTO(item));
        }
        return res;
    }
}