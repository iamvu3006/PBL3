package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ClientDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.repository.AbClientRepository;
import com.pbl3.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AbClientRepository abClientRepository;

    // 1) Xem profile
    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal) {
        String username = principal.getName();
        ClientDTO dto = authService.getClientByUsername(username);
        model.addAttribute("clientDTO", dto);
        return "view-profile";      // templates/view-profile.html
    }

    // 2) Sang trang edit
    @GetMapping("/profile/edit")
    public String editProfile(Model model, Principal principal) {
        String username = principal.getName();
        ClientDTO dto = authService.getClientByUsername(username);
        model.addAttribute("clientDTO", dto);
        return "edit-profile";      // templates/edit-profile.html
    }

    // 3) Xử lý submit từ edit-profile
    @PostMapping("/profile/edit")
    public String handleEdit(
        @ModelAttribute("clientDTO") ClientDTO dto,
        Model model,
        Principal principal
    ) {
        String username = principal.getName();
        AbClient client = abClientRepository
          .findByClientUseName(username)
          .orElseThrow();
        boolean ok = authService.updateClientProfile(client.getClientID(), dto);

        if (ok) {
          return "redirect:/profile?updated";   // redirect về view kèm param
        } else {
          model.addAttribute("error", "Mật khẩu hiện tại không đúng");
          return "edit-profile";
        }
    }
}

