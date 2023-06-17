package com.bjtu.service;

import com.bjtu.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 保存
     * @param user
     */
    public boolean save(User user);

    /**
     * 按用户名删除
     * @param username
     */
    public boolean delete(String username);

    /**
     * 修改
     * @param user
     */
    public boolean update(User user);

    /**
     * 按用户名查询
     * @param username
     * @return
     */
    public User getByName(String username);

    /**
     * 查询全部
     * @return
     */
    public List<User> getAll();
}
