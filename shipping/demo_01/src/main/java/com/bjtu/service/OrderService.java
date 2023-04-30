package com.bjtu.service;

import com.bjtu.domain.Order;

import java.util.List;

public interface OrderService {

    public boolean save(Order order);

    public int delete(int id);

    public List<Order> getByUserId(int user_id);


}
