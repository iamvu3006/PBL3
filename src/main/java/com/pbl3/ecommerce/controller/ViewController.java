package com.pbl3.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn != null && isLoggedIn) {
            return "redirect:/"; // Nếu đã đăng nhập thì chuyển về trang chủ
        }
        return "login"; // Trả về trang login.html
    }

    @GetMapping("/register")
    public String registerPage(HttpSession session) {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn != null && isLoggedIn) {
            return "redirect:/"; // Nếu đã đăng nhập thì chuyển về trang chủ
        }
        return "register"; // Trả về trang register.html
    }

    @GetMapping("/")
    public String homePage() {
        return "index"; // Trả về trang index.html (trang chủ)
    }
}