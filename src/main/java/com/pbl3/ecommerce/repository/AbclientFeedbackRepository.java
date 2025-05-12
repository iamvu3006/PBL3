package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.AbClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbclientFeedbackRepository extends JpaRepository<AbClient, Integer> {
    // Có thể thêm các phương thức truy vấn tùy chỉnh nếu cần
    // Ví dụ: tìm kiếm theo tên người dùng (clientUseName)
    AbClient findByClientUseName(String clientUseName);
}
