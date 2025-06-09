package com.pbl3.ecommerce.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pbl3.ecommerce.dto.ClientDTO;
import com.pbl3.ecommerce.dto.ClientFeedBackDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.repository.AbClientRepository;
import com.pbl3.ecommerce.service.AuthService;
import com.pbl3.ecommerce.service.FeedbackService;

@Controller
public class ProfileController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AbClientRepository abClientRepository;
    
     @Autowired
     private FeedbackService feedbackService;

    // 1) Xem profile
    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal) {
        String username = principal.getName();
        // Lấy DTO user
        ClientDTO dto = authService.getClientByUsername(username);
        model.addAttribute("clientDTO", dto);

        // Lấy feedbacks cho chính user này
        Integer clientId = abClientRepository
            .findByClientUseName(username)
            .orElseThrow(() -> new RuntimeException("User không tồn tại"))
            .getClientID();

        // FeedbackService trả về ClientFeedBackDTO chứa list Feedback
        ClientFeedBackDTO fbDto = feedbackService.getClientWithFeedback(clientId);
        model.addAttribute("feedbackData", fbDto);

        return "view-profile";
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

