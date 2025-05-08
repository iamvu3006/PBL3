package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.AuthResponse;
import com.pbl3.ecommerce.dto.LoginRequest;
import com.pbl3.ecommerce.dto.RegisterRequest;
import com.pbl3.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(HttpSession session) {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn != null && isLoggedIn) {
            return "index"; // Nếu đã đăng nhập thì chuyển về trang chủ
        }
        return "register"; // Trả về trang register.html
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    // === API Controllers ===

    @PostMapping("/api/auth/login")
    @ResponseBody
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        AuthResponse response = authService.login(loginRequest);

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
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
        AuthResponse response = authService.register(registerRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/auth/logout")
    @ResponseBody
    public ResponseEntity<AuthResponse> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(new AuthResponse(true, "Đăng xuất thành công"));
    }

    @GetMapping("/api/auth/check-session")
    @ResponseBody
    public ResponseEntity<AuthResponse> checkSession(HttpSession session) {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");

        if (isLoggedIn != null && isLoggedIn) {
            Integer clientId = (Integer) session.getAttribute("clientId");
            String username = (String) session.getAttribute("username");
            return ResponseEntity.ok(new AuthResponse(true, "Đã đăng nhập", clientId, username));
        } else {
            return ResponseEntity.ok(new AuthResponse(false, "Chưa đăng nhập"));
        }
    }
}