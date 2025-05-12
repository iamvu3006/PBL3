package com.pbl3.ecommerce.dto;

import java.util.List;

public class ClientFeedBackDTO {

    private String clientFullName;
    private String clientAdress;
    private List<FeedBackDTO> feedbackList;

    // Constructor
    public ClientFeedBackDTO(String clientFullName, String clientAdress, List<FeedBackDTO> feedbackList) {
        this.clientFullName = clientFullName;
        this.clientAdress = clientAdress;
        this.feedbackList = feedbackList;
    }

    // Getters & Setters

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public List<FeedBackDTO> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<FeedBackDTO> feedbackList) {
        this.feedbackList = feedbackList;
    }
}
