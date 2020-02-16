package com.cfh.springboottest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

//该类用于实体类和数据库之间的映射
//实体类的类名必须和数据库中的表名一致，大小写可以忽略
@Entity   //绑定实体类
@Data     //自动生产get、set方法
public class Sport {  //对应数据库中的admin表
    @Id  //是主键
    private String name;
    private String region;
    private Date date1;
    private Date date2;
    private Boolean important;
    private String miaoshu;
}
