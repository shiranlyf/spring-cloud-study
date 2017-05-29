package com.shiran.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;


/**
 * 这里类不让它被@ComponentScan注解进行扫描 
 * 启动类ComsumerMovieRibbonApplication所在的包和子包下的类都会被进行扫描
 * name表示的eureka server注册的名称
 * @author shiran
 *
 */
@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
	
//	@Autowired
//	IClientConfig  config;
	
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}

}
