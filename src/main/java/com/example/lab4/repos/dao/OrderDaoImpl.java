package com.example.lab4.repos.dao;

import com.example.lab4.entities.Order;
import com.example.lab4.entities.User;
import com.example.lab4.repos.jpa.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderDaoImpl implements OrderDao {
    private OrderRepo orderRepo;

    @Override
    public Order findByOrder_id(Long id) {
        return orderRepo.findByOrderid(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> findByClient(User client) {
        return orderRepo.findAllByClient(client);
    }

    @Override
    public void update(Order newOrder) {
        Order order = orderRepo.findByOrderid(newOrder.getOrderid());
        order.setPrice(newOrder.getPrice());
        order.setStatus(newOrder.getStatus());
        order.setComment(newOrder.getComment());
        orderRepo.save(order);
    }

    @Override
    public void save(Order order) {
        orderRepo.save(order);
    }
}
