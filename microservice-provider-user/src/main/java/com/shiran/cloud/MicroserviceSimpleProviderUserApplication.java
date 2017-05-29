package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * http://localhost:7900/simple/1
 * 这个是用户微服务的启动类：用于查询用户的信息
 * 注意：只扫描当前的包和子包 所以这个类要在包的外面
 * 
 * 将服务注册到eureka上面
 * 2.@EnableEurekaClient     注册客户端
 * @author shiran
 *
 */
@SpringBootApplication
@EnableEurekaClient    //里面也有eureka注册     
//@EnableDiscoveryClient    这个可以用于zk  consul的注册
public class MicroserviceSimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleProviderUserApplication.class, args);
	}
}
