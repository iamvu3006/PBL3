package com.pbl3.ecommerce.dto;

public class FeedbackTargetClientDTO {
    private Integer Rate;
    private String Comment;
    private Integer clientId;
    private Integer targetClientId;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getTargetClientId() {
        return targetClientId;
    }

    public void setTargetClientId(Integer targetClientId) {
        this.targetClientId = targetClientId;
    }

    public Integer getRate() {
        return Rate;
    }

    public void setRate(Integer rate) {
        Rate = rate;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
