package com.pbl3.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pbl3.ecommerce.dto.AuthResponse;
import com.pbl3.ecommerce.dto.ClientDTO;
import com.pbl3.ecommerce.dto.LoginRequest;
import com.pbl3.ecommerce.dto.RegisterRequest;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.WishListCategory;
import com.pbl3.ecommerce.repository.AbClientRepository;

@Service
public class AuthService {

    private final AbClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(AbClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // public AuthResponse login(LoginRequest loginRequest) {
    //     Optional<AbClient> clientOptional = clientRepository.findByClientUseName(loginRequest.getUsername());
    //     try {
    //         if (clientOptional.isPresent()) {
    //             AbClient client = clientOptional.get();
    //             if (passwordEncoder.matches(loginRequest.getPassword(), client.getClientPassword())) {
    //                 return new AuthResponse(true, "Đăng nhập thành công", client.getClientID(), client.getClientUseName());
    //             } else {
    //                 return new AuthResponse(false, "Mật khẩu không chính xác");
    //             }
    //         } else {
    //             return new AuthResponse(false, "Tên đăng nhập không tồn tại");
    //         }
    //     } catch (Exception e) {
            
    //         e.printStackTrace();
    //         return new AuthResponse(false, "Lỗi hệ thống: " + e.getMessage());
    //     }
    // }
    public AuthResponse login(LoginRequest loginRequest) {
        Optional<AbClient> clientOptional =
            clientRepository.findByClientUseName(loginRequest.getUsername());

        try {
            if (clientOptional.isPresent()) {
                AbClient client = clientOptional.get();
                if (passwordEncoder.matches(loginRequest.getPassword(), client.getClientPassword())) {
                    // Lấy role từ entity (giả sử bạn đã lưu trong AbClient)
                    String role = client.getRole();  // e.g. "ADMIN" hoặc "USER"
                    return new AuthResponse(
                        true,
                        "Đăng nhập thành công",
                        client.getClientID(),
                        client.getClientUseName(),
                        role                        // ← truyền role vào đây
                    );
                } else {
                    return new AuthResponse(false, "Mật khẩu không chính xác");
                }
            } else {
                return new AuthResponse(false, "Tên đăng nhập không tồn tại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AuthResponse(false, "Lỗi hệ thống: " + e.getMessage());
        }
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        try {
            if (clientRepository.existsByClientUseName(registerRequest.getUsername())) {
                return new AuthResponse(false, "Tên đăng nhập đã được sử dụng");
            }

            // Kiểm tra email đã tồn tại chưa
            if (clientRepository.existsByClientEmailAdress(registerRequest.getEmail())) {
                return new AuthResponse(false, "Email đã được sử dụng");
            }

            // Kiểm tra số điện thoại đã tồn tại chưa
            if (clientRepository.existsByClientPhoneNumber(registerRequest.getPhoneNumber())) {
                return new AuthResponse(false, "Số điện thoại đã được sử dụng");
            }

            // Tạo WishListCategory mặc định trước
            WishListCategory defaultWishList = new WishListCategory();

            // Tạo client mới
            AbClient newClient = new AbClient();
            newClient.setClientUseName(registerRequest.getUsername());
            newClient.setClientPassword(passwordEncoder.encode(registerRequest.getPassword()));
            newClient.setClientFullName(registerRequest.getFullName());
            newClient.setClientPhoneNumber(registerRequest.getPhoneNumber());
            newClient.setClientEmailAdress(registerRequest.getEmail());
            newClient.setClientAdress(registerRequest.getAddress());

            // Set wishlist cho client (sử dụng setter custom của bạn)
            newClient.setWishListCategory(defaultWishList);

            // Lưu client vào database (cascade sẽ tự động lưu wishlist)
            AbClient savedClient = clientRepository.save(newClient);

            return new AuthResponse(true, "Đăng ký thành công", savedClient.getClientID(), savedClient.getClientUseName());
        } catch (Exception e) {
            e.printStackTrace();
            return new AuthResponse(false, "Lỗi đăng ký: " + e.getMessage());
        }
    }

    // Lấy thông tin người dùng
    public ClientDTO getClientProfile(Integer clientId) {
        AbClient client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        return new ClientDTO(
            client.getClientID(),
            client.getClientFullName(),
            client.getClientPhoneNumber(),
            client.getClientEmailAdress(),
            client.getClientAdress()
        );
    }
    public ClientDTO getClientByUsername(String username) {
        AbClient client = clientRepository.findByClientUseName(username)
            .orElseThrow(() -> new RuntimeException("Client not found: " + username));
        return new ClientDTO(
            client.getClientID(),
            client.getClientFullName(),
            client.getClientPhoneNumber(),
            client.getClientEmailAdress(),
            client.getClientAdress()
        );
    }


    public boolean updateClientProfile(Integer clientId, ClientDTO requestDTO) {
        AbClient client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        if (!client.getClientPassword().equals(requestDTO.getCurrentPassword())) {
            return false;
        }

        // cập nhật nếu có giá trị mới (không null)
        if (requestDTO.getClientFullName() != null) {
            client.setClientFullName(requestDTO.getClientFullName());
        }

        if (requestDTO.getClientPhoneNumber() != null) {
            client.setClientPhoneNumber(requestDTO.getClientPhoneNumber());
        }

        if (requestDTO.getClientEmailAdress() != null) {
            client.setClientEmailAdress(requestDTO.getClientEmailAdress());
        }

        if (requestDTO.getClientAdress() != null) {
            client.setClientAdress(requestDTO.getClientAdress());
        }

        clientRepository.save(client);
        return true;
    }
    
}