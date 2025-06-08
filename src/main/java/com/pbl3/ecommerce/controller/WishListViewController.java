package com.pbl3.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pbl3.ecommerce.entity.WishListCategory;
import com.pbl3.ecommerce.service.WishListProductService;

/**
 * Controller chỉ để render trang wishlist.html
 */
@Controller
public class WishListViewController {

    @Autowired
    private WishListProductService wishListProductService;

    /**
     * Hiển thị trang /wishlist với clientId và wishListId đã nạp sẵn lên Model
     */
    @GetMapping("/wishlist")
    public String viewWishList(
            Model model,
            @AuthenticationPrincipal(expression = "id") Integer clientId
            
    ) {
        

        
        WishListCategory wishList = wishListProductService
            .getOrCreateWishListCategoryForClient(clientId);
        Integer wishListId = wishList.getWishListID();

        // Đưa lên Model cho Thymeleaf
        model.addAttribute("clientId", clientId);
        model.addAttribute("wishListId", wishListId);

        return "wishlist";  // Thymeleaf sẽ render templates/wishlist.html
    }
}
