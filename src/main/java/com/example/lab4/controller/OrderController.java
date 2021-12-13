package com.example.lab4.controller;

import com.example.lab4.dto.OrderDto;
import com.example.lab4.entities.Order;
import com.example.lab4.entities.RoleEnum;
import com.example.lab4.entities.User;
import com.example.lab4.repos.dao.OrderDao;
import com.example.lab4.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public String get(HttpSession session, Model model, @RequestParam(required = false) String order_id){
        User user = (User)session.getAttribute("user");
        if(user == null)
            return "login-invalid";
        List<Order> orders = orderService.getAllOrders(user);
        model.addAttribute("orders", orders);
        if(user.getRole().getRole_name() == RoleEnum.CLIENT)
            return "order-client";
        else if(order_id != null){
            Order order = orderService.getOrder(Long.valueOf(order_id));
            model.addAttribute("order", order);
            return "order-edit";
        }
        return "order-all";
    }

    @GetMapping("/create")
    public String get(HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        if(user.getRole().getRole_name() != RoleEnum.CLIENT)
            return "redirect:/orders";
        return "order-creation";
    }

    @PostMapping
    public String post(OrderDto orderDto, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user.getRole().getRole_name() == RoleEnum.ADMIN)
            orderService.editOrder(orderDto);
        else
            orderService.addOrder(orderDto, user);
        return "redirect:/orders";
    }
}
