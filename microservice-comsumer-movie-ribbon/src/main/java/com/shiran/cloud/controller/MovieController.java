package com.shiran.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	 * @param id
	 * @return
	 */
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		//之前用的是这个 http://localhost:7900/simple/   
		//这里使用的是VIP(virtual IP)  Haproxy  heartbeat等  就是配置的application name的名称
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	/**
	 * http://localhost:8010/test
	 * @return
	 */
	@GetMapping("/test")
	public String test(){
		//选择微服务  vip
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		//选择选择的服务实例
		System.out.println("111:" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort() );
		
		ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
		System.out.println("222:"  + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort() );
		
		return "1";
	}
	
	
	/**
	 * sidecar 
	 * @return
	 */
	@GetMapping("/sidecar")
	public String sidecar(){
		return this.restTemplate.getForObject("http://microservice-sidecar/", String.class);
	}
	
	

}
