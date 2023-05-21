package com.bjtu.dao;

import com.bjtu.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {
    @Insert("insert into orders(goods_name,num,start,end,user_id) " +
            "values(#{goods_name},#{num},#{start},#{end},#{user_id})")
    public void save(Order order);

    @Delete("delete from orders where id=#{id}")
    public int delete(int id);

    @Select("select * from orders where user_id=#{user_id}")
    public List<Order> getByUserId(int user_id);
}
