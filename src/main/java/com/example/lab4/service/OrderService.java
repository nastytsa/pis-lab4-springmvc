package com.example.lab4.service;

import com.example.lab4.dto.OrderDto;
import com.example.lab4.entities.Order;
import com.example.lab4.entities.RoleEnum;
import com.example.lab4.entities.User;
import com.example.lab4.repos.dao.OrderDaoImpl;
import com.example.lab4.repos.dao.UserDaoImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderDaoImpl orderDao;
    private final UserDaoImpl userDao;

    public List<Order> getAllOrders(User user){
        if(user.getRole().getRole_name() == RoleEnum.ADMIN)
            return orderDao.findAll();
        else
            return orderDao.findByClient(user);
    }
    public Order getOrder(Long id){
        return orderDao.findByOrder_id(id);
    }

    public void editOrder(OrderDto orderDto){
        orderDao.update(obtainOrder(orderDto));
    }

    public void addOrder(OrderDto orderDto, User user){
        Order order = new Order(user, orderDto.getContent());
        orderDao.save(order);
    }

    private Order obtainOrder(OrderDto orderDto){
        String order_id = orderDto.getOrder_id();
        String client_id = orderDto.getClient_id();
        String price = orderDto.getPrice();
        String comment = orderDto.getComment();
        String status = orderDto.getStatus();
        String content = orderDto.getContent();
        User user = userDao.findById(Long.valueOf(client_id));

        return new Order(Long.valueOf(order_id), comment, user, new BigDecimal(price), status, content);
    }
}
