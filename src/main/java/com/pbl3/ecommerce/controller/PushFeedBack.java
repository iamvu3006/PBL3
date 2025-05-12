package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.FeedbackTargetClientDTO;
import com.pbl3.ecommerce.entity.Feedback;
import com.pbl3.ecommerce.service.FeedbackTargetClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class PushFeedBack {

    @Autowired
    private FeedbackTargetClientService feedbackTargetClientService;

    @PostMapping
    public ResponseEntity<String> addFeedback(@RequestBody FeedbackTargetClientDTO dto) {
        feedbackTargetClientService.createFeedback(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tạo feedback thành công");
    }

//    @GetMapping("/target/{targetClientId}")
//    public ResponseEntity<List<Feedback>> getFeedbacksForClient(@PathVariable Integer targetClientId) {
//        return ResponseEntity.ok(feedbackTargetClientService.getFeedbacksForClient(targetClientId));
//    }
}

