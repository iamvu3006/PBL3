package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.AuthDto;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.repository.AbClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final AbClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(AbClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthDto login(AuthDto loginRequest) {
        Optional<AbClient> clientOptional = clientRepository.findByClientUseName(loginRequest.getUsername());

        if (clientOptional.isPresent()) {
            AbClient client = clientOptional.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), client.getClientPassword())) {
                return new AuthDto(true, "Đăng nhập thành công",
                        client.getClientID(), client.getClientUseName(),
                        null, client.getClientPhoneNumber(),
                        client.getClientEmailAdress(), client.getClientAdress());
            } else {
                return new AuthDto(false, "Mật khẩu không chính xác");
            }
        } else {
            return new AuthDto(false, "Tên đăng nhập không tồn tại");
        }
    }

    public AuthDto register(AuthDto registerRequest) {
        // Kiểm tra username đã tồn tại chưa
        if (clientRepository.existsByClientUseName(registerRequest.getUsername())) {
            return new AuthDto(false, "Tên đăng nhập đã được sử dụng");
        }

        // Kiểm tra email đã tồn tại chưa
        if (clientRepository.existsByClientEmailAdress(registerRequest.getEmail())) {
            return new AuthDto(false, "Email đã được sử dụng");
        }

        // Kiểm tra số điện thoại đã tồn tại chưa
        if (clientRepository.existsByClientPhoneNumber(registerRequest.getPhoneNumber())) {
            return new AuthDto(false, "Số điện thoại đã được sử dụng");
        }

        // Tạo client mới từ DTO
        AbClient newClient = new AbClient();
        newClient.setClientUseName(registerRequest.getUsername());
        newClient.setClientPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newClient.setClientFullName(registerRequest.getFullName());
        newClient.setClientPhoneNumber(registerRequest.getPhoneNumber());
        newClient.setClientEmailAdress(registerRequest.getEmail());
        newClient.setClientAdress(registerRequest.getAddress());

        // Lưu client vào database
        AbClient savedClient = clientRepository.save(newClient);

        return new AuthDto(true, "Đăng ký thành công",
                savedClient.getClientID(), savedClient.getClientUseName(),
                savedClient.getClientFullName(), savedClient.getClientPhoneNumber(),
                savedClient.getClientEmailAdress(), savedClient.getClientAdress());
    }
}