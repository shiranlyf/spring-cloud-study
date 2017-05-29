package com.shiran.cloud.feign;

import java.util.List;

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

@FeignClient(name = "microservice-provider-user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {
	
	/**
	 * 1.这里要使用RequestMapping  不能使用GetMapping注解
	 * 2.@PathVariable("id") 这里默认的id必须写  它不能默认指定
	 * 
	 * 第一次的时候访问不成功   调用断路器中的方法   关闭用户微服务的时候访问的也是断路器中的方法
	 * http://localhost:7901/health --> 健康检查
	 * http://localhost:7901/hystrix.stream -->访问这个的时候没有
	 * #feign.hystrix.enabled: false  ### 索性禁用feign的hystrix    在application.yml中可以禁用hystrix的支持
	 * @return User
	 */
	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id);
	


}
