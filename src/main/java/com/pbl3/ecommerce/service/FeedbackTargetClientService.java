package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.FeedbackTargetClientDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.Feedback;
import com.pbl3.ecommerce.repository.FeedbackTargetRepository;
import com.pbl3.ecommerce.repository.TargetClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedbackTargetClientService {

    @Autowired
    private FeedbackTargetRepository feedbackTargetRepository;

    @Autowired
    private TargetClientRepository targetClientRepository;

    @Transactional
    public Feedback createFeedback(FeedbackTargetClientDTO dto) {
        // Kiểm tra null
        if (dto == null) {
            throw new IllegalArgumentException("Dữ liệu feedback không được để trống");
        }

        if (dto.getClientId() == null) {
            throw new IllegalArgumentException("ClientID không được để trống");
        }

        if (dto.getTargetClientId() == null) {
            throw new IllegalArgumentException("TargetClientID không được để trống");
        }

        if (dto.getRate() == null) {
            throw new IllegalArgumentException("Rate không được để trống");
        }

        // Tìm client và target client
        AbClient client = targetClientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client đánh giá không tồn tại với ID: " + dto.getClientId()));

        AbClient target = targetClientRepository.findById(dto.getTargetClientId())
                .orElseThrow(() -> new RuntimeException("Client bị đánh giá không tồn tại với ID: " + dto.getTargetClientId()));

        // Tạo và lưu feedback
        Feedback feedback = new Feedback();
        feedback.setRate(dto.getRate());
        feedback.setClientComment(dto.getComment());
        feedback.setClient(client);
        feedback.setTargetClient(target);  // Chú ý: đã đổi tên từ setTargetclient thành setTargetClient

        return feedbackTargetRepository.save(feedback);
    }

    public List<Feedback> getFeedbacksForClient(Integer targetClientId) {
        if (targetClientId == null) {
            throw new IllegalArgumentException("TargetClientID không được để trống");
        }
        return feedbackTargetRepository.findByTargetClient_ClientID(targetClientId);
    }
}