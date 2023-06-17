package com.bjtu.service;

import com.bjtu.domain.Cargo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
     * @return List<Cargo>
     */
    public List<Cargo> getAll(String cargo_owner);


    /**
     * 测试查询
     * @return List<Cargo>
     */
    public List<Cargo> get();
}
