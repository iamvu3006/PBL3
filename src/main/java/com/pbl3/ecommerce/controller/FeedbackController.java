package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ClientFeedBackDTO;
import com.pbl3.ecommerce.dto.FeedbackTargetClientDTO;
import com.pbl3.ecommerce.entity.Feedback;
import com.pbl3.ecommerce.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/{clientID}")
    public ClientFeedBackDTO getClientWithFeedback(@PathVariable Integer clientID) {
        return feedbackService.getClientWithFeedback(clientID);
    }

    @PostMapping
    public ResponseEntity<String> addFeedback(@RequestBody FeedbackTargetClientDTO dto) {
        feedbackService.createFeedback(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tạo feedback thành công");
    }

    @GetMapping("/target/{targetClientId}")
    public ResponseEntity<List<Feedback>> getFeedbacksForClient(@PathVariable Integer targetClientId) {
        return ResponseEntity.ok(feedbackService.getFeedbacksForClient(targetClientId));
    }
}