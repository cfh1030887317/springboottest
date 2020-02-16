package com.cfh.springboottest.repository;

import com.cfh.springboottest.entity.Admin;
import com.cfh.springboottest.entity.Sport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest  //说明是测试类
class AdminRepositoryTest {

    @Autowired  //自动注入对象 类似于自动构造
    private AdminRepository adminRepository;

    @Autowired
    private SportRepository sportRepository;

    @Test
    void findAll(){
        System.out.printf(adminRepository.findAll().toString());
    }

    @Test
    void save(){
        //添加Admin
        Admin admin = new Admin();
        admin.setAdmin_account("saveTest");
        admin.setAdmin_password("test");
        admin.setAdmin_name("tessss");
        Admin a = adminRepository.save(admin);
        System.out.println(a);
    }

    @Test
    void sportsave(){
        Sport sport = new Sport();
        sport.setName("ssss");
        sport.setDate1(new Date());
        sport.setImportant(true);
        Sport a = sportRepository.save(sport);
        System.out.println(a);
    }

    @Test
    void sportfindAll(){
        System.out.printf(sportRepository.findAll().toString());
    }

    @Test
    void selectById(){
        Admin admin = adminRepository.findById("ee").get();  //id只是只是一个代名词,不一定是id,是主键
        System.out.println(admin);
    }

    @Test  //修改用的还是save方法
    void Adminupdate(){
        Admin admin = new Admin();
        admin.setAdmin_account("ee");
        admin.setAdmin_name("测试修改");
        admin.setAdmin_password("aa");
        admin.setXy("机械");
        Admin a = adminRepository.save(admin);
        System.out.println(a);
    }

    @Test
    void deleteAdmin(){
        adminRepository.deleteById("r");
    }
}