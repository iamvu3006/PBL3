package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ListProductItemDTO;
import com.pbl3.ecommerce.dto.ProductItemDetailDTO;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.repository.ProductItemDetailRepository;
import com.pbl3.ecommerce.service.WishListProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("api/wishlist")
public class WishListProductController {
    @Autowired
    private WishListProductService wishListProductService;

    @Autowired
    private ProductItemDetailRepository productItemDetailRepository;

    @PostMapping("/add")
    public String addToWishList(@RequestParam Integer wishListId, @RequestParam Integer productId){
        return wishListProductService.addProductToWishList(wishListId, productId);
    }

    @DeleteMapping("/delete")
    public String RemoveFromWishList(@RequestParam Integer wishLishId, @RequestParam Integer productId){
        return wishListProductService.RemoveProductFormWishList(wishLishId, productId);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ListProductItemDTO>> getFavoriteProducts(@PathVariable Integer clientId) {
        List<ListProductItemDTO> favoriteProducts = wishListProductService.getListWishProduct(clientId);
        return ResponseEntity.ok(favoriteProducts);
    }

    @GetMapping("/product-detail/{productId}")
    public ResponseEntity<ProductItemDetailDTO> getProductDetail(@PathVariable Integer productId) {
        ProductItem item = productItemDetailRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy sản phẩm"));

        return ResponseEntity.ok(new ProductItemDetailDTO(item));
    }
}

