package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * http://localhost:7900/simple/1
 * 这个是用户微服务的启动类：用于查询用户的信息
 * 注意：只扫描当前的包和子包 所以这个类要在包的外面
 * @author shiran
 *
 */
@SpringBootApplication
public class MicroserviceSimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleProviderUserApplication.class, args);
	}
}
