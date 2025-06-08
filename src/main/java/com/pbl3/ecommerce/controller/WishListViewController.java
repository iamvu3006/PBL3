package com.pbl3.ecommerce.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.WishListCategory;
import com.pbl3.ecommerce.repository.AbClientRepository;
import com.pbl3.ecommerce.service.WishListProductService;

/**
 * Controller chỉ để render trang wishlist.html
 */
@Controller
public class WishListViewController {

    @Autowired
    private AbClientRepository abClientRepository;

    @Autowired
    private WishListProductService wishListProductService;

    @GetMapping("/wishlist")
    public String viewWishList(Model model, Principal principal) {
        // Lấy username hiện tại
        String username = principal.getName();

        // Dùng đúng method của repository
        AbClient client = abClientRepository
            .findByClientUseName(username)
            .orElseThrow(() -> 
                new IllegalArgumentException("Không tìm thấy user: " + username)
            );

        Integer clientId = client.getClientID();

        // Lấy hoặc tạo wishlist
        WishListCategory wishList = 
            wishListProductService.getOrCreateWishListCategoryForClient(clientId);
        Integer wishListId = wishList.getWishListID();

        model.addAttribute("clientId", clientId);
        model.addAttribute("wishListId", wishListId);
        return "wishlist";
    }
}