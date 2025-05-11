package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.Feedback;
import com.pbl3.ecommerce.entity.AbClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    // Tìm kiếm tất cả các feedback của một khách hàng (AbClient)
    List<Feedback> findByClient(AbClient client);
}
