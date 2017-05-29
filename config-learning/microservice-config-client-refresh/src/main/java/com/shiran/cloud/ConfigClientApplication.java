package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;


/**
 * Config client  
 * 
 * 自动刷新的实现步骤：
 * 1.ConfigClientController类上添加注解 @RefreshScope
 *   原因：
 *     Refresh Scope
 *      A Spring @Bean that is marked as @RefreshScope will get special treatment 
 *      when there is a configuration change. This addresses the problem of stateful beans 
 *      that only get their configuration injected when they are initialized. 
 *      For instance if a DataSource has open connections when the database URL 
 *      is changed via the Environment, we probably want the holders of those connections 
 *      to be able to complete what they are doing. Then the next time someone borrows a connection 
 *      from the pool he gets one with the new URL.
 *      
 * 2.添加actuator依赖
 *   原因：
 *      Endpoints
 *		For a Spring Boot Actuator application there are some additional management endpoints:
 *		POST to /env to update the Environment and rebind @ConfigurationProperties and log levels
 *		/refresh for re-loading the boot strap context and refreshing the @RefreshScope beans
 *		/restart for closing the ApplicationContext and restarting it (disabled by default)
 *		/pause and /resume for calling the Lifecycle methods (stop() and start() on the ApplicationContext)
 *
 * 3.http://localhost:8081/profile 测试  E:\>curl -X POST http://localhost:8081/refresh(在cmd中进行刷新  没有actuator注解的时候是404)
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
