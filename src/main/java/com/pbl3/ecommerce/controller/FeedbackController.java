package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ClientFeedBackDTO;
import com.pbl3.ecommerce.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedBackService clientService;

    @GetMapping("/{clientID}")
    public ClientFeedBackDTO getClientWithFeedback(@PathVariable Integer clientID) {
        return clientService.getClientWithFeedback(clientID);
    }
}
