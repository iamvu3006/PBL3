package com.pbl3.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller           
@RequestMapping("/client")
public class ClientViewController {

   
    @GetMapping("/{id}/profile")
    public String viewProfilePage(
        @PathVariable Integer id,
        Model model
    ) {
        
        model.addAttribute("clientId", id);
        return "profile";  
    }
}

