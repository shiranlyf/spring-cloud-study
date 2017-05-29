package com.shiran.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shiran.config.Configuration2;

/**
 * 定义一个FeignClient的接口 
 * url请求的的地址是eureka   name表示的配置中指定的配置的名称
 * @author 释然
 * http://localhost:8761/eureka/apps    这个返回eureka的当前的服务 /可以进行指定服务的名称
 */
@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class)
public interface FeignClient2 {
	
	/**
	 * 根据serviceName进行查看指定服务的信息
	 * http://localhost:8761/eureka/apps/microservice-provider-user  可以指定服务进行eureka的服务的查看
	 * @param serviceName 
	 */
	@RequestMapping(value = "eureka/apps/{serviceName}")
	public String findServiceInfoByServiceName(@PathVariable("serviceName") String serviceName);
	
}
