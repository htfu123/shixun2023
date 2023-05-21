package com.bjtu.service.impl;

import com.bjtu.dao.UsersDao;
import com.bjtu.domain.Users;
import com.bjtu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    public boolean save(Users users){
        usersDao.save(users);
        return true;
    }

    public boolean delete(String username){
        usersDao.delete(username);
        return true;
    }

    public boolean update(Users users){
        usersDao.update(users);
        return true;
    }

  /*  public Users getByName(String username){
        Users users = usersDao.getByName(username);
        return users;
    }*/

    public List<Users> getAll(){
        List<Users> list = usersDao.getAll();
        return list;
    }
}
