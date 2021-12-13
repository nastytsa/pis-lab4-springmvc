package com.example.lab4.repos.dao;

import com.example.lab4.entities.Order;
import com.example.lab4.entities.User;

import java.util.List;

public interface OrderDao {
    Order findByOrder_id(Long id);
    List<Order> findAll();
    List<Order> findByClient(User client);
    void update(Order order);
    void save(Order order);
}
