package com.bjtu.controller;

import com.bjtu.request.IntRequest;
import com.bjtu.response.ListResponse;
import com.bjtu.response.MessageResponse;
import com.bjtu.domain.Order;
import com.bjtu.security.jwt.JwtUtils;
import com.bjtu.service.OrderService;
import com.bjtu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UsersService usersService;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/submit")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> submit(@RequestBody Order order, HttpSession session, @RequestHeader("Authorization") String tokenBearer){
        String token=tokenBearer.substring(7, tokenBearer.length());
        String username=jwtUtils.getUserNameFromJwtToken(token);
        int user_id=jwtUtils.getUserIdByJwtToken(token);
        order.setId(user_id);
        orderService.save(order);
        return ResponseEntity.ok(new MessageResponse("提交成功"));
    }
    @PostMapping("/delete")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> delete(@RequestBody IntRequest intRequest, @RequestHeader("Authorization") String tokenBearer){
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
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> get(@RequestHeader("Authorization") String tokenBearer){
        String token=tokenBearer.substring(7, tokenBearer.length());
        String username=jwtUtils.getUserNameFromJwtToken(token);
        int user_id=jwtUtils.getUserIdByJwtToken(token);
        List<Order> list=orderService.getByUserId(user_id);
        return ResponseEntity.ok(new ListResponse(list));
    }
}
