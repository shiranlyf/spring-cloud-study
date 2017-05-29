package com.shiran.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiran.cloud.entity.User;
import com.shiran.cloud.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository  userRepository;
	
	/**
	 * @RequestMapping 相当与requestMapping的的使用
	 * 这个是一个混合注解
	 * @param id
	 * @return
	 */
	@GetMapping("/simple/{id}")
	public User getUserById(@PathVariable Long id){
		return this.userRepository.findOne(id);
	}

}
