package com.bjtu.controller;

import com.bjtu.dao.UsersDao;
import com.bjtu.domain.Bills;
import com.bjtu.domain.Order;
import com.bjtu.request.IntRequest;
import com.bjtu.response.ListResponse;
import com.bjtu.response.MessageResponse;
import com.bjtu.security.jwt.JwtUtils;
import com.bjtu.service.BillsService;
import com.bjtu.service.OrderService;
import com.bjtu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;
import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillsController {
    @Autowired
    private BillsService billsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/add")
    @PreAuthorize("hasRole('CARRIER')")
    public ResponseEntity<?> add(@RequestBody Order order, @RequestHeader("Authorization") String tokenBearer){
        String token=tokenBearer.substring(7, tokenBearer.length());
        String username=jwtUtils.getUserNameFromJwtToken(token);
        int carrier_id=jwtUtils.getUserIdByJwtToken(token);
        int order_id=order.getId();
        String location=order.getStart();
        int time=4;
        double pay=1000;
        Bills bills=new Bills(order_id,carrier_id,location,time,pay);
        billsService.save(bills);
        return ResponseEntity.ok(new MessageResponse("接单成功"));
    }
    @PostMapping("/get-order")
    @PreAuthorize("hasRole('CARRIER')")
    public ResponseEntity<?> getByOrderId(@RequestBody IntRequest intRequest, @RequestHeader("Authorization") String tokenBearer){
        List<Bills> list=billsService.getByOrderId(intRequest.getId());
        return ResponseEntity.ok(new ListResponse(list));
    }
    @PostMapping("/get-carrier")
    @PreAuthorize("hasRole('CARRIER')")
    public ResponseEntity<?> getByCarrierId(@RequestBody IntRequest intRequest, @RequestHeader("Authorization") String tokenBearer){
        List<Bills> list=billsService.getByCarrierId(intRequest.getId());
        return ResponseEntity.ok(new ListResponse(list));
    }
}
