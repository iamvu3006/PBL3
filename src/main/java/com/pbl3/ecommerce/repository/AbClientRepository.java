package com.pbl3.ecommerce.repository;

import com.pbl3.ecommerce.entity.AbClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbClientRepository extends JpaRepository<AbClient, Integer> {
    Optional<AbClient> findByClientUseName(String username);
    Optional<AbClient> findByClientEmailAdress(String email);
    Optional<AbClient> findByClientPhoneNumber(String phoneNumber);
    boolean existsByClientUseName(String username);
    boolean existsByClientEmailAdress(String email);
    boolean existsByClientPhoneNumber(String phoneNumber);
}