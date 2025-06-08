package com.pbl3.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminViewController {

   
    @GetMapping("/admin")
    public String adminDashboard() {
      
        return "admin";
    }
}
