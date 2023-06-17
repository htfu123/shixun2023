package com.bjtu.controller;

import com.bjtu.domain.Cargo;
import com.bjtu.domain.User;
import com.bjtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Objects;

import static com.bjtu.controller.Code.*;

//@Controller
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/cargo")
    public Result getlist(){
        String url = "http://cargoserver/cargo/list";
        Result result = restTemplate.getForObject(url, Result.class);
        return result;
    }

    @GetMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null) {
            Result result = new Result(LOGIN_ERR, "用户名不能为空");
            return result;
        }
        if (password == null) {
            Result result = new Result(LOGIN_ERR, "密码不能为空");
            return result;
        }
        if (userService.getByName(username) == null) {
            Result result = new Result(LOGIN_ERR, "用户名或者密码错误");
            return result;
        }
        if (Objects.equals(userService.getByName(username).getPassword(), password)) {
            session.setAttribute("username", username);
            Result result = new Result(LOGIN_OK, "登陆成功");
            return result;
        } else {
            Result result = new Result(LOGIN_ERR, "用户名或者密码错误");
            return result;
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user, HttpSession session) {
        if (user.getUsername() == null) {
            Result result = new Result(REGISTER_ERR, "用户名不能为空");
            return result;
        }
        if (user.getPassword() == null) {
            Result result = new Result(REGISTER_ERR, "密码不能为空");
            return result;
        }
        if (userService.getByName(user.getUsername()) != null) {
            Result result = new Result(REGISTER_ERR, "用户名已存在");
            return result;
        } else {
            //注册成功
            userService.save(user);
            Result result = new Result(REGISTER_OK, "注册成功");
            return result;
        }
    }
}
