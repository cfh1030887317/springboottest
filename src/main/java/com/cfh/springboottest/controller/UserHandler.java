package com.cfh.springboottest.controller;

import com.cfh.springboottest.entity.Admin;
import com.cfh.springboottest.entity.User;
import com.cfh.springboottest.repository.AdminRepository;
import com.cfh.springboottest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController  //返回json数据,让外部能访问到该方法
@RequestMapping("/user")  //请求地址
public class UserHandler {

    @Autowired
    private UserRepository userRepository;  //实现了接口类，该接口封装数据库调用方法

    //查询方法
    @GetMapping("/findAll/{page}/{size}")  //需要前端传递一个page当前页码,size每页的大小,get方法
    public Page<User> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page,size); //当前页数0, 取三条数据
        return  userRepository.findAll(pageRequest);  //返回的是一个Page对象
    }

    //添加方法
    @PostMapping("/save")
    public String save(@RequestBody User user){  //@RequestBody 能转换json格式
        User result = userRepository.save(user);
        //返回给前端的值
        if(result != null){
            return "success";
        }else {
            return "error";
        }
    }

    //根据主键来查信息
    @GetMapping("/findById/{account}")
    public User findById(@PathVariable("account") String account){  //解析地址栏的信息
        return userRepository.findById(account).get();
    }

    //修改信息 修改的时候用put方法
    @PutMapping("/updateUser")
    public String update(@RequestBody User user){
        User result = userRepository.save(user);
        if(result != null){
            return "success";
        }else {
            return "error";
        }
    }

    //删除操作
    @DeleteMapping("/deleteUser/{account}")
    public void Delete(@PathVariable("account") String account){
        userRepository.deleteById(account);
    }
}
