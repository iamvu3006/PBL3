package com.pbl3.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pbl3.ecommerce.dto.AuthResponse;
import com.pbl3.ecommerce.dto.LoginRequest;
import com.pbl3.ecommerce.dto.RegisterRequest;
import com.pbl3.ecommerce.service.AuthService;

import jakarta.servlet.http.HttpSession;

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        try {
            System.out.println("Login request received: " + loginRequest.getUsername());
            AuthResponse response = authService.login(loginRequest);

            if (response.isSuccess()) {
                session.setAttribute("clientId", response.getClientId());
                session.setAttribute("username", response.getUsername());
                session.setAttribute("isLoggedIn", true);
                System.out.println("Login successful for user: " + loginRequest.getUsername());
            } else {
                System.out.println("Login failed for user: " + loginRequest.getUsername());
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in login: " + e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new AuthResponse(false, "Lỗi hệ thống: " + e.getMessage()));
        }
    }

    @PostMapping("/api/auth/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
        try {
            AuthResponse response = authService.register(registerRequest);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new AuthResponse(false, "Lỗi hệ thống: " + e.getMessage()));
        }
    }

    @PostMapping("/api/auth/logout")
    public ResponseEntity<AuthResponse> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AuthResponse(true, "Đăng xuất thành công"));
    }

    @GetMapping("/api/auth/check-session")
    public ResponseEntity<AuthResponse> checkSession(HttpSession session) {
        try {
            Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");

            if (isLoggedIn != null && isLoggedIn) {
                Integer clientId = (Integer) session.getAttribute("clientId");
                String username = (String) session.getAttribute("username");
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new AuthResponse(true, "Đã đăng nhập", clientId, username));
            } else {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new AuthResponse(false, "Chưa đăng nhập"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new AuthResponse(false, "Lỗi kiểm tra phiên: " + e.getMessage()));
        }
    }
}