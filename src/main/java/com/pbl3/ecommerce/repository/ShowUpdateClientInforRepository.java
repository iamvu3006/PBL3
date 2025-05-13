package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.AbClient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ShowUpdateClientInforRepository extends JpaRepository<AbClient, Integer> {
    Optional<AbClient> findByClientID(Integer id);
}
