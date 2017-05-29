package com.shiran.cloud.feign;

import org.springframework.stereotype.Component;

import com.shiran.cloud.entity.User;

/**
 * 添加这个注解 @Component 不然不能得到这个instance实例
 * @author shiran
 *
 */
@Component
public class HystrixClientFallback implements UserFeignClient {

	@Override
	public User getUserById(Long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}


	
 
}