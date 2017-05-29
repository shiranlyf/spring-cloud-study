package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.stereotype.Component;


/**
 * 
 * 1. Zuul Hystrix fallbake 
 * @Component
 * public class MyFallbackProvider implements ZuulFallbackProvider {}
 *
 * zuul  hystrix fallback配置
 * http://localhost:8040/microservice-provider-user/simple/1(关闭用户微服务的时候就会  返回fallback)
 * http://localhost:8040/routes (这个可以查看代理的路由地址)
 * http://localhost:8040/hystrix.stream   查看zuul hystrix单点服务信息
 * 
 * 
 * 2. @HystrixCommand(fallbackMethod = "defaultStores") -->Ribbon fallback  这个是通用的属性
 * @Component
 *  public class StoreIntegration {
 *
 *   @HystrixCommand(fallbackMethod = "defaultStores")
 *   public Object getStores(Map<String, Object> parameters) {
 *       //do stuff that might fail
 *   }
 *   public Object defaultStores(Map<String, Object> parameters) {
 *       return something useful;
 *   }
 * }
 * 
 * 3.Feign  fallbake (通过FeignClient的属性进行控制)
 *  @FeignClient(name = "hello", fallback = HystrixClientFallback.class)
 *  protected interface HystrixClient {
 *    @RequestMapping(method = RequestMethod.GET, value = "/hello")
 *    Hello iFailSometimes();
 *  }
 * 
 * Polyglot support with Sidecar（进行不同语言的易购微服务进行纳入到spring cloud的生态圈中）
 * 1.The Spring Cloud Netflix Sidecar was inspired by Netflix Prana(灵感来源)
 * 
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
