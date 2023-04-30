package com.bjtu.service;

import com.bjtu.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsersServiceTest {
    @Autowired
    private UsersService usersService;

    @Test
    public void testGetByUsername() {
        Users users = usersService.getByName("chen");
        System.out.println(users);
    }

    @Test
    public void testGetAll(){
        List<Users> list= usersService.getAll();
        System.out.println(list);
    }

    @Test
    public void testSave(){
        usersService.save(new Users("Alan","1234",0,123456));
    }
    @Test
    public void testDelete(){
        usersService.delete("Alan");
    }
    @Test
    public void testUpdate(){
        usersService.update(new Users("Alan","!!!1234",0,66666));
    }

}
