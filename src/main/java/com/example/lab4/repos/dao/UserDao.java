package com.example.lab4.repos.dao;

import com.example.lab4.entities.User;

import java.util.Optional;

public interface UserDao {
    User findByIdAndPassword(Long id, String password);
    User findById(Long id);
}
