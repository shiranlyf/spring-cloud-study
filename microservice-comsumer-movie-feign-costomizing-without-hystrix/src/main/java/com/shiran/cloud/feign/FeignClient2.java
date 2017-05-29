package com.shiran.cloud.feign;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netflix.hystrix.HystrixCommand;
import com.shiran.config.Configuration2;

import feign.Feign;
import feign.hystrix.HystrixFeign;

/**
 * 定义一个FeignClient的接口 
 * url请求的的地址是eureka   name表示的配置中指定的配置的名称
 * @author 释然
 * http://localhost:8761/eureka/apps    这个返回eureka的当前的服务 /可以进行指定服务的名称
 * 
 * 
 * 
 * 查看feign支持hystrix的支持的步骤：configuration --->FeignClientsConfiguration ---->
 *  @Configuration
 *	@ConditionalOnClass({ HystrixCommand.class, HystrixFeign.class })
 *	protected static class HystrixFeignConfiguration {
 *		@Bean
 *		@Scope("prototype")
 *		@ConditionalOnMissingBean
 *		@ConditionalOnProperty(name = "feign.hystrix.enabled", matchIfMissing = true) 
 *		public Feign.Builder feignHystrixBuilder() {
 *			return HystrixFeign.builder();
 *		}
 *	}
 *
 *
 *
 */
@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class, fallback = FeignClientFallBack.class)
public interface FeignClient2 {
	
	/**
	 * 根据serviceName进行查看指定服务的信息
	 * http://localhost:8761/eureka/apps/microservice-provider-user  可以指定服务进行eureka的服务的查看
	 * @param serviceName 
	 */
	@RequestMapping(value = "eureka/apps/{serviceName}")
	public String findServiceInfoByServiceName(@PathVariable("serviceName") String serviceName);
	
}
