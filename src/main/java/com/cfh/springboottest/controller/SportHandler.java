package com.cfh.springboottest.controller;

import com.cfh.springboottest.entity.Admin;
import com.cfh.springboottest.entity.Sport;
import com.cfh.springboottest.repository.AdminRepository;
import com.cfh.springboottest.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 采用jpa的方式实现数据库
 */

@RestController
@RequestMapping("/sport")
public class SportHandler {
    @Autowired
    private SportRepository sportRepository;  //实现了接口类，该接口封装数据库调用方法

    //添加活动
    @PostMapping("/save")
    public String save(@RequestBody Sport sport){  //@RequestBody 能转换json格式
        Sport result = sportRepository.save(sport);
        //返回给前端的值
        if(result != null){
            return "success";
        }else {
            return "error";
        }
    }

    //查询所有活动
    @GetMapping("/findAll/{page}/{size}")  //需要前端传递一个page当前页码,size每页的大小,get方法
    public Page<Sport> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page,size); //当前页数0, 取三条数据
        return  sportRepository.findAll(pageRequest);  //返回的是一个Page对象
    }

    //删除操作
    @DeleteMapping("/deleteSport/{name}")
    public void Delete(@PathVariable("name") String name){
        sportRepository.deleteById(name);
    }

    @PutMapping("/updateSport")
    public String update(@RequestBody Sport sport){
        Sport result = sportRepository.save(sport);
        if(result != null){
            return "success";
        }else {
            return "error";
        }
    }

    //按照name查询对象
    @GetMapping("/findById/{name}")
    public Sport findById(@PathVariable("name") String name){
        //也可以自定义Jpa方法让其返回不是List而是对象
        return sportRepository.findById(name).get();
    }

}
