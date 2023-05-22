package com.bjtu.controller;

import com.bjtu.domain.Cargo;
import com.bjtu.domain.Result;
import com.bjtu.security.jwt.JwtUtils;
import com.bjtu.service.CargoService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static com.bjtu.domain.Code.*;

//@Controller
@CrossOrigin(origins = {"*","null"})
@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;
    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER')")
    public Result getAll(@RequestHeader("Authorization") String tokenBearer){
        String token=tokenBearer.substring(7, tokenBearer.length());
        String username=jwtUtils.getUserNameFromJwtToken(token);
        int user_id=jwtUtils.getUserIdByJwtToken(token);
        List<Cargo> list=cargoService.getAll(username);
        Result result;
        if(list.isEmpty()){
            result=new Result(list,LIST_ERR,"查询失败");
        }
        else {
            result=new Result(list,LIST_OK,"查询成功");
        }
        System.out.println(list);
        return result;
    }

    @PostMapping("/submit")
    @PreAuthorize("hasRole('USER')")
    public Result submit(@RequestBody Cargo cargo, @RequestHeader("Authorization") String tokenBearer){
        String token=tokenBearer.substring(7, tokenBearer.length());
        String cargo_owner=jwtUtils.getUserNameFromJwtToken(token);
        int user_id=jwtUtils.getUserIdByJwtToken(token);
        cargo.setCargo_owner(cargo_owner);
        int num=cargoService.save(cargo);
        System.out.println(cargo);
        Result result=new Result(num,SUBMIT_OK,"提交成功");
        return result;
    }

    @PostMapping("/edit")
    @PreAuthorize("hasRole('USER')")
    public Result edit(@RequestBody Cargo cargo){
        int flag=cargoService.update(cargo);
        Result result;
        if(flag==0){
            result=new Result(flag,EDIT_ERR,"没有该货物");
        }
        else {
            result=new Result(flag,EDIT_OK,"编辑成功");
        }
        return result;
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER')")
        public Result delete(@PathVariable Integer id){
        System.out.println(id);
        int flag=cargoService.delete(id);
        Result result;
        if(flag==0)
        {
            result=new Result(flag,DELETE_ERR,"没有该货物");
        }
        else {
            result=new Result(flag,DELETE_OK,"删除成功");
        }
        return result;
    }
}
