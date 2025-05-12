package com.pbl3.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pbl3.ecommerce.dto.AuthDto;
import com.pbl3.ecommerce.service.AuthService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // === View Controllers ===

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

    // === API Controllers ===

    @PostMapping("/api/auth/login")
    @ResponseBody
    public ResponseEntity<AuthDto> login(@RequestBody AuthDto loginRequest, HttpSession session) {
        AuthDto response = authService.login(loginRequest);

        if (response.isSuccess()) {
            // Lưu thông tin đăng nhập vào session
            session.setAttribute("clientId", response.getClientId());
            session.setAttribute("username", response.getUsername());
            session.setAttribute("isLoggedIn", true);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/auth/register")
    @ResponseBody
    public ResponseEntity<AuthDto> register(@RequestBody AuthDto registerRequest) {
        AuthDto response = authService.register(registerRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/auth/logout")
    @ResponseBody
    public ResponseEntity<AuthDto> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(new AuthDto(true, "Đăng xuất thành công"));
    }

    @GetMapping("/api/auth/check-session")
    @ResponseBody
    public ResponseEntity<AuthDto> checkSession(HttpSession session) {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");

        if (isLoggedIn != null && isLoggedIn) {
            Integer clientId = (Integer) session.getAttribute("clientId");
            String username = (String) session.getAttribute("username");
            return ResponseEntity.ok(new AuthDto(true, "Đã đăng nhập", clientId, username));
        } else {
            return ResponseEntity.ok(new AuthDto(false, "Chưa đăng nhập"));
        }
    }
}