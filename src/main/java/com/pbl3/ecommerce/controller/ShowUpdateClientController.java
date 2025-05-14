package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ShowClientInforDTO;
import com.pbl3.ecommerce.dto.UpdateClientDTO;
import com.pbl3.ecommerce.service.ShowUpdateClientInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ShowUpdateClientController {

    @Autowired
    private ShowUpdateClientInforService clientService;

    @GetMapping("/{id}/profile")
    public ResponseEntity<ShowClientInforDTO> getProfile(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.getClientProfile(id));
    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<?> updateProfile(@PathVariable Integer id,
                                           @RequestBody UpdateClientDTO requestDTO) {
        boolean success = clientService.updateClientProfile(id, requestDTO);
        if (success) {
            return ResponseEntity.ok("Cập nhật thành công");
        } else {
            return ResponseEntity.badRequest().body("Mật khẩu không đúng");
        }
    }

}