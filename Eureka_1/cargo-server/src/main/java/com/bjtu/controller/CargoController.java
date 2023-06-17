package com.bjtu.controller;

import com.bjtu.domain.Cargo;
import com.bjtu.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.bjtu.controller.Code.*;

@RestController
@RequestMapping("/cargo")
@CrossOrigin
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('p1')")
    public Result getAll(HttpSession session){
        System.out.println(session.getAttribute("username"));
//        List<Cargo> list=cargoService.getAll((String) session.getAttribute("username"));
        List<Cargo> list=cargoService.get();
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
    @PreAuthorize("hasAuthority('p1')")
    public Result submit(@RequestBody Cargo cargo, HttpSession session){
        String cargo_owner=(String) session.getAttribute("username");
        cargo.setCargo_owner(cargo_owner);
        int num=cargoService.save(cargo);
        System.out.println(cargo);
        Result result=new Result(num,SUBMIT_OK,"提交成功");
        return result;
    }

    @PutMapping("/edit")
    @PreAuthorize("hasAuthority('p1')")
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

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('p1')")
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
