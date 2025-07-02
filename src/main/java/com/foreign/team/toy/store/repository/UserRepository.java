package com.foreign.team.toy.store.repository;
import com.foreign.team.toy.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository <User, Long> {
    boolean existsByEmail(String email);
}