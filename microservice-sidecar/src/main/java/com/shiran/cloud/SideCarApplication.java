package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * 
 * D:\setup\node-v6.10.3>node F:\setup\spring-tool-suite-3.8.4.RELEASE-e4.6.3-win32-x86_64\workspace\code\node-service\node-service.js
 * http://localhost:8040/routes
 * http://localhost:8040/microservice-sidecar    //nodejs 首页
 * http://localhost:8040/microservice-sidecar/health.json  
 * 
 * 使用movie-ribbon进行调用nodejs的断点（使用）  sidecar可以监控监控异构的微服务状态
 * http://localhost:8010/sidecar
 * http://localhost:8070/health
 * 
 * sidecar 和  异构的项目要在同一个host上 否则配置：${eureka.instance.hostName}
 * 
 * sideCar补充：
 * 1.http://localhost:8070/health中localApplication的status就是nodejs中的status的状态 LocalApplicationHealthIndicator类源码查看
 * 2.SidecarController
 * @author shiran
 */

@SpringBootApplication
@EnableSidecar
public class SideCarApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(SideCarApplication.class, args);
    }
}
