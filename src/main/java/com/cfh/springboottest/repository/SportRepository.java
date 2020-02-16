package com.cfh.springboottest.repository;


import com.cfh.springboottest.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;


//集成jpa仓库 里面填写<实体类类型,主键的类型>
//该接口用于绑定实体类，调用数据库数据
public interface SportRepository extends JpaRepository<Sport, String> {

}
