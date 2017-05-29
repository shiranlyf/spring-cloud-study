package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * 
 * eureka-ha的执行流程：
 * 要eureka上的所有的注册信息通过之后 才会产生一个实例    
 *   因为在每一个eureka中都注册了一个user的节点    在所有的eureka中都能购找到
 *   
 * eureka启动类：http://localhost:8761/ - 首页地址
 * @author shiran
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaHaApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaHaApplication.class, args);
    }
}
