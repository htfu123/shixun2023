package com.bjtu.dao;

import com.bjtu.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UsersDao {
    @Insert("insert into users(username,password,identity,phone) " +
            "values(#{username},#{password},#{identity},#{phone})")
    public void save(Users users);

    @Delete("delete from users where username=#{username}")
    public void delete(String username);

    @Update("update users set username=#{username},password=#{password},identity=#{identity},phone=#{phone}" +
            "where username=#{username}")
    public void update(Users users);

    @Select("select * from users where username=#{username}")
    public Optional<Users> getByName(String username);

    @Select("select * from users where username=#{username}")
    public Users getByName2(String username);

    @Select("select * from users")
    public List<Users> getAll();
}
