package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * eureka启动类：http://localhost:8761/ - 首页地址
 * @author shiran
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
