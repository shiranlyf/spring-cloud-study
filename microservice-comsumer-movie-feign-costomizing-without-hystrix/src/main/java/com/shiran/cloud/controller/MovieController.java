package com.shiran.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shiran.cloud.feign.FeignClient2;
import com.shiran.cloud.feign.UserFeignClient;
import com.shiran.cloud.entity.User;

/**
 * http://localhost:7901/movie/1
 * movie controller
 * @author shiran
 */
@RestController
public class MovieController {
	
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private FeignClient2 feignClient2;
	
	
	/**
	 * @return
	 */
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return this.userFeignClient.getUserById(id);
	}
	
	/**
	 * http://localhost:7901/test/MICROSERVICE-PROVIDER-USER
	 * http://localhost:7901/test/microservice-provider-user
	 * 指定服务的vip  进行服务信息的打印
	 * 这里没有进行配置   所以使用的springmvc的注解
	 * @param serviceName
	 * @return
	 */
	@GetMapping("/test/{serviceName}")
	public String findServiceInfoByServiceName(@PathVariable String serviceName){
		return this.feignClient2.findServiceInfoByServiceName(serviceName);
	}

	
}
