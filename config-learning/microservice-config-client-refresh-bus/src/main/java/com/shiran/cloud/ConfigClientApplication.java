package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;


/**
 * Config client  
 * 
 * Spring cloud bus开发步骤：
 *  1.依赖包
 *   	<!-- spring cloud bus -->
 *		<dependency>
 *		    <groupId>org.springframework.cloud</groupId>
 *		    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
 *		</dependency>
 *  2.配置bootsrap.yml
 *    
 * 
 */
@SpringBootApplication
public class ConfigClientApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
