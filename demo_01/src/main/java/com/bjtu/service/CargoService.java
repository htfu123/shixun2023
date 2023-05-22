package com.bjtu.service;

import com.bjtu.domain.Cargo;
import com.bjtu.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CargoService {
    /**
     * 保存
     * @param cargo
     */
    public int save(Cargo cargo);

    /**
     * 按货物号删除
     * @param id
     */
    public int delete(int id);

    /**
     * 修改
     * @param cargo
     */
    public int update(Cargo cargo);

    /**
     * 按用户名查询
     * @param cargo_name
     * @return
     */
    public Cargo getByName(String cargo_name);

    /**
     * 查询全部
     * @return
     */
    public List<Cargo> getAll(String cargo_owner);

}
