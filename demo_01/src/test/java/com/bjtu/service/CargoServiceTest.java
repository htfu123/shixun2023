package com.bjtu.service;

import com.bjtu.domain.Cargo;
import com.bjtu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CargoServiceTest {

    @Autowired
    private CargoService cargoService;

    @Test
    public void testGetByUsername(){
        Cargo cargo = cargoService.getByName("电脑");
        System.out.println(cargo);
    }

    @Test
    public void testGetAll(){
        List<Cargo> all=cargoService.getAll("chen");
        System.out.println(all);
    }

    @Test
    public void update(){
        Cargo cargo_new=new Cargo();
        cargo_new.setCargo_name("键盘");
        int isOk=cargoService.update(cargo_new);
    }

    @Test
    public void insert(){
        Cargo cargo_new=new Cargo("书本","广东","北京",111,"chen");
        int isOk=cargoService.save(cargo_new);
    }

    @Test
    public void delete(){
        int id=3;
        int isOk=cargoService.delete(id);
    }
}
