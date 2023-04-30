package com.bjtu.service.impl;

import com.bjtu.dao.OrderDao;
import com.bjtu.domain.Order;
import com.bjtu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public boolean save(Order order){
        orderDao.save(order);
        return true;
    }

    public int delete(int id){
        return orderDao.delete(id);
    }

    public List<Order> getByUserId(int user_id){
        List<Order> list= orderDao.getByUserId(user_id);
        return list;
    }
}
