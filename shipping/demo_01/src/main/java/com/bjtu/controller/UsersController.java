package com.bjtu.controller;

import com.bjtu.dao.RolesDao;
import com.bjtu.dao.UsersDao;
import com.bjtu.domain.ERole;
import com.bjtu.domain.Roles;
import com.bjtu.domain.Users;
import com.bjtu.request.RegisterRequest;
import com.bjtu.response.JwtResponse;
import com.bjtu.response.MessageResponse;
import com.bjtu.security.jwt.JwtUtils;
import com.bjtu.security.services.UserDetailsImpl;
import com.bjtu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UsersDao usersDao;
    @Autowired
    RolesDao rolesDao;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        if(registerRequest.getUsername()==null){
            return ResponseEntity.ok(new MessageResponse("用户名不能为空"));
        }
        if(registerRequest.getPassword()==null) {
            return ResponseEntity.ok(new MessageResponse("密码不能为空"));
        }
        if(usersDao.getByName2(registerRequest.getUsername())!=null)
        {
            return ResponseEntity.ok(new MessageResponse("用户名已存在"));
        }
        else{
            //注册成功
            Users users = new Users(registerRequest.getUsername(),
                    encoder.encode(registerRequest.getPassword()),
                    registerRequest.getIdentity(),
                    registerRequest.getPhone());
            Set<Roles> roles = new HashSet<>();
            int oneRole=registerRequest.getIdentity();
            if (oneRole == 0) {
                Roles userRole = rolesDao.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: the role roll is not found."));
                roles.add(userRole);
            }
            else if(oneRole == 1)
            {
                Roles userRole = rolesDao.findByName(ERole.ROLE_CARRIER)
                        .orElseThrow(() -> new RuntimeException("Error: the role roll is not found."));
                roles.add(userRole);
            }
            registerRequest.setPassword(encoder.encode(registerRequest.getPassword()));
            users.setRoles(roles);
            usersService.save(users);
            return ResponseEntity.ok(new MessageResponse("注册成功"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users users) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));

            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getUsername(),
                    roles));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.ok(new MessageResponse("用户名或密码错误！"));
        }
    }
        /*String username=users.getUsername();
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

    }*/
}
