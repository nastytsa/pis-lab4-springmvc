package com.example.lab4.repos.dao;

import com.example.lab4.entities.User;
import com.example.lab4.repos.jpa.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserDaoImpl implements UserDao{
    private UserRepo userRepo;

    @Override
    public User findByIdAndPassword(Long id, String password) {
        return userRepo.findByIdAndPassword(id, password);
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent())
            return user.get();
        return null;
    }
}
