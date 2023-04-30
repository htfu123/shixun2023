package com.bjtu.controller;

import com.bjtu.request.IntRequest;
import com.bjtu.response.ListResponse;
import com.bjtu.response.MessageResponse;
import com.bjtu.domain.Order;
import com.bjtu.service.OrderService;
import com.bjtu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UsersService usersService;

    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody Order order, HttpSession session){
        String username=(String) session.getAttribute("username");
        int user_id=usersService.getByName(username).getId();
        order.setId(user_id);
        orderService.save(order);
        return ResponseEntity.ok(new MessageResponse("提交成功"));
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody IntRequest intRequest){
        int id=intRequest.getId();
        int flag=orderService.delete(id);
        if(flag>0)
        {
            return ResponseEntity.ok(new MessageResponse("删除成功"));
        }
        else
            return ResponseEntity.ok(new MessageResponse("删除失败"));
    }
    @PostMapping("/get")
    public ResponseEntity<?> get(HttpSession session){
        String username=(String) session.getAttribute("username");
        int user_id=usersService.getByName(username).getId();
        List<Order> list=orderService.getByUserId(user_id);
        return ResponseEntity.ok(new ListResponse(list));
    }
}
