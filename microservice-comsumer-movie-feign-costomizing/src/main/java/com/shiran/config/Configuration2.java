package com.shiran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

/**
 * 进行配置授权的配置类
 * @author shiran 
 * @Configuration:使用Configuration进行注解
 */
@Configuration
public class Configuration2 {

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		//这里指定eureka的用户名和密码
		return new BasicAuthRequestInterceptor("user", "password123");
	}

}
