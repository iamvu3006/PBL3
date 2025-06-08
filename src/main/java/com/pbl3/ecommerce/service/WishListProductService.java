package com.pbl3.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbl3.ecommerce.dto.ListProductItemDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.entity.WishListCategory;
import com.pbl3.ecommerce.entity.WishListProduct;
import com.pbl3.ecommerce.repository.AbClientRepository;
import com.pbl3.ecommerce.repository.ProductItemRepository;
import com.pbl3.ecommerce.repository.WishListCategoryRepository;
import com.pbl3.ecommerce.repository.WishListProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WishListProductService {

    @Autowired
    private WishListProductRepository wishListProductRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private WishListCategoryRepository wishListCategoryRepository;
    @Autowired
    private AbClientRepository abClientRepository;

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
    public WishListCategory getOrCreateWishListCategoryForClient(Integer clientId) {
        // 1) Thử tìm đã có
        Optional<WishListCategory> opt = wishListCategoryRepository
            .findByAbClient_ClientID(clientId);
        if (opt.isPresent()) {
            return opt.get();
        }

        // 2) Chưa có → load AbClient từ DB
        AbClient client = abClientRepository
            .findById(clientId)
            .orElseThrow(() -> new EntityNotFoundException(
                  "Không tìm thấy client với id=" + clientId));

        // 3) Tạo mới category, gắn client
        WishListCategory newCat = new WishListCategory();
        newCat.setAbClient(client);
        // (nếu WishListCategory có các field khác như tên, ngày tạo,... thì set thêm)
        return wishListCategoryRepository.save(newCat);
    }
}
