package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 
 * 电影微服务的启动类
 * 添加到eureka的注解   这样才可以进行扫描   
 * @author shiran
 * 
 *
 */

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceSimpleComsumerMovieApplication {
	
    //方法名称作为实例化对象的名称   相当于new 出一个实例对象
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleComsumerMovieApplication.class, args);
	}
}
