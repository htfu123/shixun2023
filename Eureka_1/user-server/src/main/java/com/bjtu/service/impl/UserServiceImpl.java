package com.bjtu.service.impl;

import com.bjtu.dao.UserDao;
import com.bjtu.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements com.bjtu.service.UserService {

    @Autowired
    private UserDao userDao;

    public boolean save(User user){
        userDao.save(user);
        return true;
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public boolean delete(String username){
        userDao.delete(username);
        return true;
    }

    public boolean update(User user){
        userDao.update(user);
        return true;
    }

    public User getByName(String username){
        User user = userDao.getByName(username);
        return user;
    }

    public List<User> getAll(){
        List<User> list = userDao.getAll();
        return list;
    }
    public String fallbackMethod(String id) {
        // 处理熔断后的逻辑
        return "熔断";
    }
}
