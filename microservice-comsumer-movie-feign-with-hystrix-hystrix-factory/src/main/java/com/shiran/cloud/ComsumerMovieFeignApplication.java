package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
 * http://localhost:8010/movie/1
 * http://localhost:8030/hystrix  （填写 ->http://localhost:8010/hystrix.stream）
 * 
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ComsumerMovieFeignApplication {
	
	public static void main(String[] args) {
		//TOPO  8 minutes
		SpringApplication.run(ComsumerMovieFeignApplication.class, args);
	}
}
