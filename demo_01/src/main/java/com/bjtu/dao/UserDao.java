package com.bjtu.dao;

import com.bjtu.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserDao {
    @Insert("insert into tb_user(username,password,identity) " +
            "values(#{username},#{password},0)")
    public void save(User user);

    @Delete("delete from tb_user where username=#{username}")
    public void delete(String username);

    @Update("update tb_user set username=#{username},password=#{password},identity=#{identity}" +
            "where username=#{username}")
    public void update(User user);

    @Select("select * from tb_user where username=#{username}")
    public Optional<User> getByName(String username);

    @Select("select * from tb_user where username=#{username}")
    public User getByName2(String username);
    @Select("select * from tb_user")
    public List<User> getAll();
}
