package com.shiran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Contract;
import feign.Logger;

/**
 * 这个包所在的位置要与app main不在通过或者子包下(会与componentScan冲突)
 * 
 * @author shiran feign的自定义文件
 */

@Configuration
public class Configuration1 {

	/**
	 * feign默认使用springmvc的契约 这里配置的feign的注解
	 * 
	 * @return
	 */
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}

	/**
	 * 日志级别的打印  
	 * 所有的日志级别都进行打印
	 * @return
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

}
