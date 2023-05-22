package com.bjtu.service.impl;

import com.bjtu.dao.CargoDao;
import com.bjtu.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements com.bjtu.service.CargoService {

    @Autowired
    private CargoDao cargoDao;

    public int save(Cargo cargo){
        return cargoDao.save(cargo);
    }

    public int delete(int id){
        return cargoDao.delete(id);
    }

    public int update(Cargo cargo){
        return cargoDao.update(cargo);
    }

    public Cargo getByName(String cargo_name){
        Cargo cargo = cargoDao.getByName(cargo_name);
        return cargo;
    }

    public List<Cargo> getAll(String cargo_owner){
        List<Cargo> list = cargoDao.getAll(cargo_owner);
        return list;
    }
}
