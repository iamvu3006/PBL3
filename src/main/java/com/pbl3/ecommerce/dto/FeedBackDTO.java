package com.pbl3.ecommerce.dto;

public class FeedBackDTO {

    private Integer rate;
    private String clientComment;

    // Constructor
    public FeedBackDTO(Integer rate, String clientComment) {
        this.rate = rate;
        this.clientComment = clientComment;
    }

    // Getters & Setters

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getClientComment() {
        return clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }
}
