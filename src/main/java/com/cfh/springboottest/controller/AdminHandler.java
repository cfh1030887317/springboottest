package com.cfh.springboottest.controller;

import com.cfh.springboottest.entity.Admin;
import com.cfh.springboottest.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController  //返回json数据,让外部能访问到该方法
@RequestMapping("/admin")  //请求地址
public class AdminHandler {

    @Autowired
    private AdminRepository adminRepository;  //实现了接口类，该接口封装数据库调用方法

    //查询方法
    @GetMapping("/findAll/{page}/{size}")  //需要前端传递一个page当前页码,size每页的大小,get方法
    public Page<Admin> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page,size); //当前页数0, 取三条数据
        return  adminRepository.findAll(pageRequest);  //返回的是一个Page对象
    }

    //添加方法
    @PostMapping("/save")
    public String save(@RequestBody Admin admin){  //@RequestBody 能转换json格式
        Admin result = adminRepository.save(admin);
        //返回给前端的值
        if(result != null){
            return "success";
        }else {
            return "error";
        }
    }

    //根据主键来查信息
    @GetMapping("/findById/{account}")
    public Admin findById(@PathVariable("account") String account){  //解析地址栏的信息
        return adminRepository.findById(account).get();
    }

    //修改信息 修改的时候用put方法
    @PutMapping("/updateAdmin")
    public String update(@RequestBody Admin admin){
        Admin result = adminRepository.save(admin);
        if(result != null){
            return "success";
        }else {
            return "error";
        }
    }

    //删除操作
    @DeleteMapping("/deleteAdmin/{account}")
    public void Delete(@PathVariable("account") String account){
        adminRepository.deleteById(account);
    }
}
