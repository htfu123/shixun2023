package com.bjtu.controller;

import com.bjtu.domain.Result;
import com.bjtu.domain.User;
import com.bjtu.response.MessageResponse;
import com.bjtu.security.jwt.JwtUtils;
import com.bjtu.security.services.UserDetailsImpl;
import com.bjtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.bjtu.domain.Code.*;

//@Controller
@CrossOrigin(origins = {"*","null"})
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@Valid @RequestBody User user) {
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
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            System.out.println("jwt:"+jwt);
            Result result = new Result(jwt,LOGIN_OK, "登陆成功");
            return result;
        } catch (BadCredentialsException ex) {
            Result result = new Result(LOGIN_ERR, "用户名或者密码错误");
            return result;
        }
        /*if (userService.getByName(username) == null) {
            Result result = new Result(LOGIN_ERR, "用户名或者密码错误");
            return result;
        }*/
//        if (Objects.equals(userService.getByName(username).getPassword(), password)) {
//            session.setAttribute("username", username);
//            System.out.println(username);
//            Result result = new Result(LOGIN_OK, "登陆成功");
//            return result;
//        } else {
//            Result result = new Result(LOGIN_ERR, "用户名或者密码错误");
//            return result;
//        }
    }

    @PostMapping("/register")
    public Result register(@Valid @RequestBody User user) {
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
            user.setPassword(encoder.encode(user.getPassword()));
            userService.save(user);
            Result result = new Result(REGISTER_OK, "注册成功");
            return result;
        }
    }
}
