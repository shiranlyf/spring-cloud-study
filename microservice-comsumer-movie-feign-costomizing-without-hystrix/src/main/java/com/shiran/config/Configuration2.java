package com.shiran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;

/**
 * 进行配置授权的配置类
 * 
 * @author shiran
 * @Configuration:使用Configuration进行注解
 */
@Configuration
public class Configuration2 {

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		// 这里指定eureka的用户名和密码
		return new BasicAuthRequestInterceptor("user", "password123");
	}

	/**
	 * 这里是禁用Hystrix的支持
	 * To disable Hystrix support on a per-client basis
	 * 在Configuration2中进行禁用单个hystrix支持的配置
	 * 2.Feign.Builder feignBuilder: HystrixFeign.Builder  表示feign支持Hystrix的支持
	 * @return
	 */
	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}

}
