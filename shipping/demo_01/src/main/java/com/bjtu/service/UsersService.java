package com.bjtu.service;

import com.bjtu.domain.Users;

import java.util.List;

public interface UsersService {
    public boolean save(Users users);

    public boolean delete(String username);

    public boolean update(Users users);

    //public Users getByName(String username);

    public List<Users> getAll();
}
