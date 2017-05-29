package com.shiran.cloud;

import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;


/**
 * 
 * #microservice-provider-user eureka中vip application.yml(  name: microservice-provider-user-v1    
 *  #配置服务的名称  这里最好使用全部的小写  介意全部使用小写)
 * http://localhost:8040/v1/microservice-provider-user/simple/1<==>http://localhost:7900/simple/1
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
    
    
    
    /**
     * 将servicePattern注入到routePattern路由正则表达式中
     * public PatternServiceRouteMapper(String servicePattern, String routePattern) {
	 *	this.servicePattern = Pattern.compile(servicePattern);
     *  this.routePattern = routePattern;
	 *  }
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
            "(?<name>^.+)-(?<version>v.+$)",
            "${version}/${name}");
    }
    
}
