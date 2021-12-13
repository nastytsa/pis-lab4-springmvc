package com.example.lab4.repos.jpa;

import com.example.lab4.entities.Order;
import com.example.lab4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findByOrderid(Long id);

    List<Order> findAllByClient(User client);

}
