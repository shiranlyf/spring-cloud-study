package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * 电影微服务的启动类
 * 添加到eureka的注解   这样才可以进行扫描   
 * @author shiran
 * ctrl + configuration:  可以查看configuration默认配置(RibbonClientConfiguration)
 * 
 * 
 * 
 * hystrix的使用步骤：
 * 1.添加依赖：
 *   <!-- hystrix依赖的使用 -->
 *		<dependency>
 *		    <groupId>org.springframework.cloud</groupId>
 *		    <artifactId>spring-cloud-starter-hystrix</artifactId>
 *		</dependency>
 *2.在启动类上添加注解@EnableCircuitBreaker
 *3.在方法上添加注解 @HystrixCommand(fallbackMethod = "defaultStores")
 *4.编写defaultStores方法 (参数和返回值要保持一致)
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ComsumerMovieRibbonApplication {
	
    //方法名称作为实例化对象的名称   相当于new 出一个实例对象
	//@LoadBalanced  使用ribbon的负载均衡的作用  默认使用轮询的方式进行负载均衡
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ComsumerMovieRibbonApplication.class, args);
	}
}
