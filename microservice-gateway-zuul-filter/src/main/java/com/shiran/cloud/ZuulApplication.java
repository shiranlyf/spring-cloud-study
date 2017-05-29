package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


/**
 * http://localhost:8040/microservice-provider-user/simple/1（microservice-gateway-zuul-filter eureka  user ）启动  
 * zuul-filter过滤器的配置与设置
 * @author shiran
 */

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZuulApplication.class, args);
    }
    
    //zuul filter annotation 
    @Bean
    public PreZuulFilter preZuulFilter(){
    	return new PreZuulFilter();
    }
}
