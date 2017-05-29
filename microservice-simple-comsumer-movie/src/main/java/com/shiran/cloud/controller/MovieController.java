package com.shiran.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${user.userServicePath}")
	private String userServicePath;
	
	/**
	 * 在请求movie微服务的时候  会进行user微服务的请求
	 * 也就是movie的api消费的user微服务的api 
	 * 各个微服务之间是服务自治的   服务之间的启动独立
	 * @param id
	 * @return
	 */
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject(this.userServicePath + id, User.class);
	}
	
	
	

}
