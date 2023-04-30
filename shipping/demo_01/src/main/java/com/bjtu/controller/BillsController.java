package com.bjtu.controller;

import com.bjtu.domain.Bills;
import com.bjtu.domain.Order;
import com.bjtu.request.IntRequest;
import com.bjtu.response.ListResponse;
import com.bjtu.response.MessageResponse;
import com.bjtu.service.BillsService;
import com.bjtu.service.OrderService;
import com.bjtu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Order order, HttpSession session){
        String username=(String) session.getAttribute("username");
        int carrier_id=usersService.getByName(username).getId();
        int order_id=order.getId();
        String location=order.getStart();
        int time=4;
        double pay=1000;
        Bills bills=new Bills(order_id,carrier_id,location,time,pay);
        billsService.save(bills);
        return ResponseEntity.ok(new MessageResponse("接单成功"));
    }
    @PostMapping("/get-order")
    public ResponseEntity<?> getByOrderId(@RequestBody IntRequest intRequest){
        List<Bills> list=billsService.getByOrderId(intRequest.getId());
        return ResponseEntity.ok(new ListResponse(list));
    }
    @PostMapping("/get-carrier")
    public ResponseEntity<?> getByCarrierId(@RequestBody IntRequest intRequest){
        List<Bills> list=billsService.getByCarrierId(intRequest.getId());
        return ResponseEntity.ok(new ListResponse(list));
    }
}
