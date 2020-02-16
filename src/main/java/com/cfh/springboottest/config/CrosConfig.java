package com.cfh.springboottest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.jws.WebMethod;
/*
    CrosConfig用于解决跨域问题 即端口号不一致
 */
@Configuration  //该类是配置类
public class CrosConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")   //允许请求的方法
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
