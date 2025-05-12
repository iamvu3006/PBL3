package com.pbl3.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedBackID;

    private Integer rate;

    private String clientComment;

    @ManyToOne
    @JoinColumn(name = "clientID")
    private AbClient client;

    @ManyToOne
    @JoinColumn(name = "targetclientfeedback")
    private AbClient targetClient;


// getters & setters
    public Integer getFeedBackID() {
        return feedBackID;
    }

    public void setFeedBackID(Integer feedBackID) {
        this.feedBackID = feedBackID;
    }

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

    public AbClient getClient() {
        return client;
    }

    public void setClient(AbClient client) {
        this.client = client;
    }

    public AbClient getTargetClient() {
        return targetClient;
    }

    public void setTargetClient(AbClient targetClient) {
        this.targetClient = targetClient;
    }
}
