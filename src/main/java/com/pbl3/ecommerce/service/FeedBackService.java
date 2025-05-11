package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.ClientFeedBackDTO;
import com.pbl3.ecommerce.dto.FeedBackDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.Feedback;
import com.pbl3.ecommerce.repository.AbclientFeedbackRepository;
import com.pbl3.ecommerce.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedBackService {

    @Autowired
    private AbclientFeedbackRepository abClientRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

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
}
