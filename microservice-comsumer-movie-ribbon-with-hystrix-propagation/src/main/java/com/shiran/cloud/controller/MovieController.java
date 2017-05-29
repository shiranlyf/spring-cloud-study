package com.shiran.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shiran.cloud.entity.User;

/**
 * http://localhost:7901/movie/1
 * movie controller
 * @author shiran
 */
@RestController
public class MovieController {
	
	
	
	//使用restTemplate进行调用 
	//restTemplate的命名要和启动类中new 的RestTemplate保持一致 
	@Autowired
	private RestTemplate restTemplate;  
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	/**
	 * http://localhost:8010/movie/1(通过ribbon的方式访问用户微服务)
	 * 在请求movie微服务的时候  会进行user微服务的请求
	 * 也就是movie的api消费的user微服务的api 
	 * 各个微服务之间是服务自治的   服务之间的启动独立
	 * 
	 * 断路器中的注解
	 * http://localhost:8010/hystrix.stream  状态
	 * #不配置@HystrixCommand和请求的实在不同的进程中
	 *   commandProperties = @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
	 * @param id
	 * @return
	 */
	@GetMapping("/movie/{id}")  
	@HystrixCommand(fallbackMethod = "findByIdFallBack", commandProperties = @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"))
	public User findById(@PathVariable Long id){
		//之前用的是这个 http://localhost:7900/simple/   
		//这里使用的是VIP(virtual IP)  Haproxy  heartbeat等  就是配置的application name的名称
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	/**
	 * 第一次请求的时候就会超时   所以调用这个函数
	 * fallbackMethod(这个是hystrix的的方法)
	 * 参数和返回值要和原方法一致
	 * @return
	 */
	public User findByIdFallBack(Long id){
		User user = new User();
		user.setId(0);
		return user;
	}
}
