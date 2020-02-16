package com.cfh.springboottest;

import com.cfh.springboottest.entity.Admin;
import com.cfh.springboottest.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class SpringboottestApplicationTests {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    void contextLoads() {
        PageRequest pageRequest = PageRequest.of(0,3); //当前页数0, 取三条数据
        Page<Admin> page = adminRepository.findAll(pageRequest);
        int i = 0;
    }

}
