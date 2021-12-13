package com.example.lab4.repos.jpa;

import com.example.lab4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByIdAndPassword(Long id, String password);
    Optional<User> findById(Long id);
}
