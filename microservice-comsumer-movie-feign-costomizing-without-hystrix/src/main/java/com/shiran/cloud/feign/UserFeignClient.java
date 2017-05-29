package com.shiran.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.shiran.cloud.entity.User;
import com.shiran.config.Configuration1;

import feign.Param;
import feign.RequestLine;

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
 * 这个只为这个FeignClient进行配置    
 * 
 * hystrix部分：
 * 保持hystrix的支持
 * 
 */
@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class, fallback = HystrixClientFallback.class)
public interface UserFeignClient {

	
	
	/**
	 * 使用feign默认配置的注解形式
	 * @param id
	 * @return
	 */
	@RequestLine("GET /simple/{id}")
	public User getUserById(@Param("id") Long id);

}
