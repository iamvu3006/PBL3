package com.pbl3.ecommerce.config;

import com.pbl3.ecommerce.entity.WishListCategory;
import com.pbl3.ecommerce.repository.WishListCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.repository.AbClientRepository;

@Configuration
public class AdminInitializer {

    @Bean
    public CommandLineRunner init(AbClientRepository repo, PasswordEncoder encoder, WishListCategoryRepository wishlistRepo) {
        return args -> {
            if (repo.findByClientUseName("admin").isEmpty()) {
                // Tạo wishlist cho admin
                WishListCategory wishlist = new WishListCategory();
                // Tạo tài khoản admin
                AbClient admin = new AbClient();
                admin.setClientUseName("admin");
                admin.setClientPassword(encoder.encode("admin123"));
                admin.setClientFullName("Super Admin");
                admin.setClientPhoneNumber("0000000000");
                admin.setClientEmailAdress("admin@example.com");
                admin.setClientAdress("Admin Street");
                admin.setRole("ADMIN");

                // Gán wishlist
                admin.setWishListCategory(wishlist); // Quan hệ 2 chiều đã xử lý trong setter
                repo.save(admin);
            }
        };
    }

}
