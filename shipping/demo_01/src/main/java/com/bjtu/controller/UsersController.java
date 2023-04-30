package com.bjtu.controller;

import com.bjtu.response.MessageResponse;
import com.bjtu.domain.Users;
import com.bjtu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users users){
        if(users.getUsername()==null){
            return ResponseEntity.ok(new MessageResponse("用户名不能为空"));
        }
        if(users.getPassword()==null) {
            return ResponseEntity.ok(new MessageResponse("密码不能为空"));
        }
        if(usersService.getByName(users.getUsername())!=null)
        {
            return ResponseEntity.ok(new MessageResponse("用户名已存在"));
        }
        else{
            //注册成功
            usersService.save(users);
            return ResponseEntity.ok(new MessageResponse("注册成功"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users users, HttpSession session){
        String username=users.getUsername();
        String password=users.getPassword();
        if(username==null){
            return ResponseEntity.ok(new MessageResponse("用户名不能为空"));
        }
        if(password==null) {
            return ResponseEntity.ok(new MessageResponse("密码不能为空"));
        }
        if(usersService.getByName(username)==null)
        {
            return ResponseEntity.ok(new MessageResponse("用户名或密码错误"));
        }
        if(Objects.equals(usersService.getByName(username).getPassword(), password))
        {
            session.setAttribute("username",username);
            return ResponseEntity.ok(new MessageResponse("登陆成功"));
        }
        else
            return ResponseEntity.ok(new MessageResponse("用户名或密码错误"));

    }
}
