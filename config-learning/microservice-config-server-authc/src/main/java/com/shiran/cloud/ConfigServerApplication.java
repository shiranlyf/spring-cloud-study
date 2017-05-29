package com.shiran.cloud;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * Config Server  security 
 * 
 * 使用步骤：
 * 1.加依赖
 * 2.进行启动  （启动的时候回在控制台打印随机的user用户的登录密码     http://localhost:8080/）
 * 3.http://localhost:8080/master/simple-default.properties（访问git仓库中的配置信息）
 *   
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
