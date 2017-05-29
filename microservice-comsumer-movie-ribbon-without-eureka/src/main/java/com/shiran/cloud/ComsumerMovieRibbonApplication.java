package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;


/**
 * 
 * 电影微服务的启动类
 * 添加到eureka的注解   这样才可以进行扫描   
 * @author shiran
 * ctrl + configuration:  可以查看configuration默认配置(RibbonClientConfiguration)
 *
 *这些是java配置的代码：
 *@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
 */

@SpringBootApplication
@EnableEurekaClient
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
