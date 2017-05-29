package com.shiran.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
	
	//使用value注解可以读取application.yml中的配置
	@Value("${profile}") 
	private String profile;

	/**
	 * http://localhost:8081/profile
	 * @return
	 */
	@GetMapping("/profile")
	public String getProfile(){
		//ctrl + 1 可以创建没有的变量
		return profile;
	}

}
