package com.bjtu.dao;

import com.bjtu.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    @Insert("insert into tb_user(username,password,identity) " +
            "values(#{username},#{password},#{identity})")
    public void save(User user);

    @Delete("delete from tb_user where username=#{username}")
    public void delete(String username);

    @Update("update tb_user set username=#{username},password=#{password},identity=#{identity}" +
            "where username=#{username}")
    public void update(User user);

    @Select("select * from tb_user where username=#{username}")
    public User getByName(String username);

    @Select("select * from tb_user")
    public List<User> getAll();
}
