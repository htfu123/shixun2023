package com.bjtu.dao;

import com.bjtu.domain.Cargo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CargoDao {
    @Insert("insert into cargo(cargo_name,cargo_start,cargo_end,cargo_num,cargo_time,cargo_owner) " +
            "values(#{cargo_name},#{cargo_start},#{cargo_end},#{cargo_num},#{cargo_time},#{cargo_owner})")
    public int save(Cargo cargo);

    @Delete("delete from cargo where cargo_id=#{cargo_id}")
    public int delete(int id);

    @Update("update cargo set cargo_start=#{cargo_start}," +
            "cargo_end=#{cargo_end},cargo_num=#{cargo_num},cargo_time=#{cargo_time}" +
            "where cargo_id=#{cargo_id}")
    public int update(Cargo cargo);

    @Select("select * from cargo where cargo_name=#{cargo_name}")
    public Cargo getByName(String cargo_name);

    @Select("select * from cargo where cargo_owner=#{cargo_owner}")
    public List<Cargo> getAll(String cargo_owner);

    @Select("select * from cargo")
    public List<Cargo> get();
}
