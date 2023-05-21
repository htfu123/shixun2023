package com.bjtu.dao;

import com.bjtu.domain.Bills;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BillsDao {
    @Insert("insert into bills(order_id,carrier_id,location,time,pay) " +
            "values(#{order_id},#{carrier_id},#{location},#{time},#{pay})")
    public void save(Bills bills);

    @Select("select * from bills where order_id=#{order_id}")
    public List<Bills> getByOrderId(int order_id);

    @Select("select * from bills where carrier_id=#{carrier_id}")
    public List<Bills> getByCarrierId(int carrier_id);
}
