package com.shiran.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shiran.cloud.entity.User;

/**
 * @FeignClient("stores") -- 表示请求的微服务 和ribbon差不多
 * @author shiran
 * 第一次可以回出现超时：可以将虚拟ip转化成ip注册到eureka中
 * 
 * 这个表示默认的配置
 * @FeignClient(name = "microservice-provider-user")  这里尽量不用serviceId 
 * 
 * #表示以前name不是必须的  现在name是必须的    意思就是写url的是name不能不写
 * Previously, using the url attribute, did not require the name attribute. Using name is now required.
 * 
 * 
 * 
 */

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
	
	/**
	 * 1.这里要使用RequestMapping  不能使用GetMapping注解
	 * 2.@PathVariable("id") 这里默认的id必须写  它不能默认指定
	 * @return
	 */
	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id);
	
	
	/**
	 * post请求的方法测试
	 * method = RequestMethod.GET 这里使用GET也可以进行使用
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User postUser(@RequestBody User user);
	
	
	/**
	 * 该请求不会成功  只要参数是复杂对象时   该请求不会成功   feign依然会忆post方法进行请求
	 * public User getUser(@RequestParam("id" long id, @.......)); 可以
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/get-user", method = RequestMethod.GET)
	public User getUser(User user);
	

}
