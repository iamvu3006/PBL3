package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.ClientFeedBackDTO;
import com.pbl3.ecommerce.dto.FeedBackDTO;
import com.pbl3.ecommerce.dto.FeedbackTargetClientDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.Feedback;
import com.pbl3.ecommerce.repository.AbClientRepository;
import com.pbl3.ecommerce.repository.FeedbackRepository;
import com.pbl3.ecommerce.repository.FeedbackTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private AbClientRepository abClientRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackTargetRepository feedbackTargetRepository;

    public ClientFeedBackDTO getClientWithFeedback(Integer clientID) {
        AbClient client = abClientRepository.findById(clientID)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy client"));

        List<Feedback> feedbacks = feedbackRepository.findByClient(client);

        List<FeedBackDTO> feedbackDTOs = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            FeedBackDTO dto = new FeedBackDTO(
                    feedback.getRate(),
                    feedback.getClientComment()
            );
            feedbackDTOs.add(dto);
        }

        return new ClientFeedBackDTO(
                client.getClientFullName(),
                client.getClientAdress(),
                feedbackDTOs
        );
    }

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
        AbClient client = abClientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client đánh giá không tồn tại với ID: " + dto.getClientId()));

        AbClient target = abClientRepository.findById(dto.getTargetClientId())
                .orElseThrow(() -> new RuntimeException("Client bị đánh giá không tồn tại với ID: " + dto.getTargetClientId()));

        // Tạo và lưu feedback
        Feedback feedback = new Feedback();
        feedback.setRate(dto.getRate());
        feedback.setClientComment(dto.getComment());
        feedback.setClient(client);
        feedback.setTargetClient(target);

        return feedbackTargetRepository.save(feedback);
    }

    public List<Feedback> getFeedbacksForClient(Integer targetClientId) {
        if (targetClientId == null) {
            throw new IllegalArgumentException("TargetClientID không được để trống");
        }
        return feedbackTargetRepository.findByTargetClient_ClientID(targetClientId);
    }
}