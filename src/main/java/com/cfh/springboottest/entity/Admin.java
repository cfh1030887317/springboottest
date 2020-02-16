package com.cfh.springboottest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

//该类用于实体类和数据库之间的映射
//实体类的类名必须和数据库中的表名一致，大小写可以忽略
@Entity   //绑定实体类
@Data     //自动生产get、set方法
public class Admin {  //对应数据库中的admin表
    @Id  //说明admin_account是主见
    private String admin_account;
    private String admin_name;
    private String admin_password;
    private String xy;
}
