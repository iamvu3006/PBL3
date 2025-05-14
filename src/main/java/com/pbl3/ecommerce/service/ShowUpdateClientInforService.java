package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.ShowClientInforDTO;
import com.pbl3.ecommerce.dto.UpdateClientDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.repository.ShowUpdateClientInforRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowUpdateClientInforService {

    @Autowired
    private ShowUpdateClientInforRepository showClientInforRepository;

    // Lấy thông tin người dùng
    public ShowClientInforDTO getClientProfile(Integer clientId) {
        AbClient client = showClientInforRepository.findByClientID(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        ShowClientInforDTO dto = new ShowClientInforDTO();
        dto.setClientFullName(client.getClientFullName());
        dto.setClientPhoneNumber(client.getClientPhoneNumber());
        dto.setClientEmailAdress(client.getClientEmailAdress());
        dto.setClientAdress(client.getClientAdress());

        return dto;
    }

    public boolean updateClientProfile(Integer clientId, UpdateClientDTO requestDTO) {

        AbClient client = showClientInforRepository.findByClientID(clientId)
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

        showClientInforRepository.save(client);
        return true;
    }
}