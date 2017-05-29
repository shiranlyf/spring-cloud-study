package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Config client
 */
@SpringBootApplication
@EnableDiscoveryClient  //eureka客户端注解
public class ConfigClientApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
