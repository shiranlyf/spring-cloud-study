package com.shiran.cloud;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * Config Server
 * 
 * 使用步骤：
 * 1.加依赖
 * 2.加注解
 * 3.加配置
 * 4.访问：http://localhost:8080/abc-default.properties
 *       https://github.com/shiranlyf/spring-cloud
 *       http://localhost:8080/master/foobar-dev.properties
 *       http://localhost:8080/default/master      --- 返回的是一个json数据
 *       http://localhost:8080/foobar-dev/master   --指定profile的时候  也同时将default（application.*） 中的配置数据进行返回
 *       
 * application.yml.bak2
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
