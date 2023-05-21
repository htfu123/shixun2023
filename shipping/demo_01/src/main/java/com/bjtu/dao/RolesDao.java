package com.bjtu.dao;

import com.bjtu.domain.ERole;
import com.bjtu.domain.Roles;
import com.bjtu.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface RolesDao {
    @Select("select * from roles where name=#{name}")
    public Optional<Roles> findByName(ERole name);
}
