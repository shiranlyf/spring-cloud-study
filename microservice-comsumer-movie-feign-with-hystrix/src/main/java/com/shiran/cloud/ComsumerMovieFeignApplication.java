package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 
 * 电影微服务的启动类
 * 添加到eureka的注解   这样才可以进行扫描   
 * @author shiran
 * 
 * 
 * dashboard的使用的步骤：
 * 1.添加依赖
 *   <!-- feign  and dashboard 主要是添加hystrix metris指标 -->
 *	    <dependency>
 *	        <groupId>org.springframework.cloud</groupId>
 *	        <artifactId>spring-cloud-starter-hystrix</artifactId>
 *	    </dependency>
 *2.在启动类上添加 @EnableCircuitBreaker 注解
 *3.现在就可以进行访问http://localhost:7901/hystrix.stream中的信息了  同时可以进行dashboard的检测
 *  里面显示的是请求的访问信息和请求的是哪个微服务
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ComsumerMovieFeignApplication {
	
	public static void main(String[] args) {
		//TOPO  8 minutes
		SpringApplication.run(ComsumerMovieFeignApplication.class, args);
	}
}
