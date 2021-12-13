package com.example.lab4.service;

import com.example.lab4.dto.LoginDto;
import com.example.lab4.entities.User;
import com.example.lab4.repos.dao.UserDaoImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {
    private final UserDaoImpl userDao;

    public User getUser(LoginDto loginDto){
        return userDao.findByIdAndPassword(loginDto.getId(), loginDto.getPassword());
    }
}
