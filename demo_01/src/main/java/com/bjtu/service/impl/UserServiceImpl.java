package com.bjtu.service.impl;

import com.bjtu.dao.UserDao;
import com.bjtu.domain.User;
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

    public boolean delete(String username){
        userDao.delete(username);
        return true;
    }

    public boolean update(User user){
        userDao.update(user);
        return true;
    }

    public User getByName(String username){
        User user = userDao.getByName2(username);
        return user;
    }

    public List<User> getAll(){
        List<User> list = userDao.getAll();
        return list;
    }
}
