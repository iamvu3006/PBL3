package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackTargetRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByTargetClient_ClientID(Integer targetClientId);
}

