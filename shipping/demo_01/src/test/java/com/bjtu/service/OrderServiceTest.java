package com.bjtu.service;

import com.bjtu.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Test
    public void TestSave(){
        orderService.save(new Order("汽车",10,"北京","上海",1));
    }
    @Test
    public void TestDelete(){
        orderService.delete(1);
    }
    @Test
    public void TestGetByUserId(){
        orderService.getByUserId(1);
    }
}
