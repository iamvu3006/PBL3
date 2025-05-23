package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.AuthResponse;
import com.pbl3.ecommerce.dto.ClientDTO;
import com.pbl3.ecommerce.dto.LoginRequest;
import com.pbl3.ecommerce.dto.RegisterRequest;
import com.pbl3.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        try {
            System.out.println("Login request received: " + loginRequest.getUsername());
            AuthResponse response = authService.login(loginRequest);

            if (response.isSuccess()) {
                // Set session attributes
                session.setAttribute("clientId", response.getClientId());
                session.setAttribute("username", response.getUsername());
                session.setAttribute("isLoggedIn", true);

                // Create authentication token and set it in security context
                Authentication auth = new UsernamePasswordAuthenticationToken(
                    response.getUsername(),
                    null,
                    java.util.Collections.emptyList()
                );
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(auth);
                session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

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

    @PostMapping("/auth/register")
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

    @PostMapping("/auth/logout")
    public ResponseEntity<AuthResponse> logout(HttpSession session) {
        // Clear security context
        SecurityContextHolder.clearContext();
        // Invalidate session
        session.invalidate();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AuthResponse(true, "Đăng xuất thành công"));
    }

    @GetMapping("/auth/check-session")
    public ResponseEntity<AuthResponse> checkSession(HttpSession session) {
        try {
            Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if (isLoggedIn != null && isLoggedIn && auth != null && auth.isAuthenticated()) {
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

    @GetMapping("/client/{id}/profile")
    public ResponseEntity<ClientDTO> getProfile(@PathVariable Integer id) {
        return ResponseEntity.ok(authService.getClientProfile(id));
    }

    @PutMapping("/client/{id}/profile")
    public ResponseEntity<?> updateProfile(@PathVariable Integer id,
                                           @RequestBody ClientDTO requestDTO) {
        boolean success = authService.updateClientProfile(id, requestDTO);
        if (success) {
            return ResponseEntity.ok("Cập nhật thành công");
        } else {
            return ResponseEntity.badRequest().body("Mật khẩu không đúng");
        }
    }
}