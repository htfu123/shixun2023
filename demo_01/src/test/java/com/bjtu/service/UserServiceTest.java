package com.bjtu.service;

import com.bjtu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetByUsername() {
        User user = userService.getByName("chen");
        System.out.println(user);
    }

    @Test
    public void testGetAll(){
        List<User> list=userService.getAll();
        System.out.println(list);
    }

    @Test
    public void testSave(){
        userService.save(new User("Alan","1234","0"));
    }
    @Test
    public void testDelete(){
        userService.delete("Alan");
    }
    @Test
    public void testUpdate(){
        userService.update(new User("Alan","!!!1234","0"));
    }

}
