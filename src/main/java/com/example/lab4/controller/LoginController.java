package com.example.lab4.controller;

import com.example.lab4.dto.LoginDto;
import com.example.lab4.entities.User;
import com.example.lab4.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping
    public String get() {
        return "login";
    }

    @PostMapping
    public String post(LoginDto loginDto, HttpSession session){
        User user = loginService.getUser(loginDto);
        session.setAttribute("user", user);

        return "redirect:/orders";
    }
}
