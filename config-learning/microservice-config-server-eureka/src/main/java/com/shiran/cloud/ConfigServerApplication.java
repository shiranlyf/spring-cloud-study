package com.shiran.cloud;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
 * 
 * 启动的项目：
 * microservice-discovery-config-eureka   eureka server 
 * microservice-config-server-eureka      config server
 * microservice-config-client-eureka      config client 
 * 
 * 
 * http://192.168.1.144:8081/profile    客户端可以得到config server端的配置进行git中配置的获取
 * http://192.168.1.144:8081/health     可以进行查看健康状态
 * 
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient    // eureka注解     用于client的服务发现
public class ConfigServerApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
