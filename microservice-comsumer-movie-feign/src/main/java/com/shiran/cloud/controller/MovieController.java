package com.shiran.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shiran.cloud.UserFeignClient;
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
	
	
	/**
	 * 会进行自动封装对象
	 * post方法测试
	 * http://localhost:7901/test?id=1&username=zhangsan&name=zhangsan  返回的时候回忆json格式进行
	 * 使用打断点进行测试
	 */
	@GetMapping("/test")
	public User  postUser(User user){
		return this.userFeignClient.postUser(user);
	}
	
	//改请求不能成功
	@GetMapping("/test-get")
	public User getUser(User user){
		return this.userFeignClient.getUser(user);
	}
	
}
