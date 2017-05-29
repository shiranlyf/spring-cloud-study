package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * #microservice-provider-user eureka中vip
 * http://localhost:8040/microservice-provider-user/simple/1    
 * @author shiran
 *
 */

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
