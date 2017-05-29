package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * 
 * dashboard
 * 
 * 1、dashboard首页：http://localhost:8030/hystrix
 * 
 * eureka启动类：http://localhost:8761/ - 首页地址
 * @author shiran
 *
 */

@EnableHystrixDashboard
@SpringBootApplication
public class EurekaApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
