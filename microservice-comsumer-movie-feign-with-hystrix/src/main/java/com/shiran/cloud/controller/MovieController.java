package com.shiran.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

	
	/**
	 * @return
	 */
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return this.userFeignClient.getUserById(id);
	}
	
	
	
}
