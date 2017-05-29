package com.shiran.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.shiran.cloud.entity.User;

import feign.hystrix.FallbackFactory;

/**
 * HystrixFactory编写
 * 
 * 编写的步骤：
 * 1.添加@Component注解 2.实现FallbackFactory接口 并制定相应的接口泛型 
 * 3.编写一个接口 并继承
 * UserFeignClient
 * 4.在HystrixClientFactory类的方法中return的时候进行返回UserFeignClientWithFactory对象
 * 并实现相应的方法 5.返回user对象
 * 
 * 
 * @author shiran
 */

@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient> {

	// 进行日志的打印
	private static final Logger  LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);

	@Override
	public UserFeignClient create(Throwable cause) {
		
		//进行日志打印      {}表示的占位符   已进入fallback就能拦截到异常
		HystrixClientFactory.LOGGER.info("fallback; reason was: {}", cause.getMessage());
		
		//匿名类---->lambla
		//在 配置中 save Action --> configuration --> code .. (可以将代码的方格改成lamba格式     就是将匿名函数的格式修改)
		return new UserFeignClientWithFactory() {
 
			@Override
			public User getUserById(Long id) {
				User user = new User();
				user.setId(-1L); // 这个是为了进行fallback的区分
				return user;
			}
		};
	}

}
