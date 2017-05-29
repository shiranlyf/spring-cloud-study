package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
/**
 * turbine:
 * 
 * turbine.stream:http://localhost:8031/turbine.stream
 * 
 * http://pz-20151127xhgd:8081/hystrix.stream   管理端口进行
 * http://localhost:8010/ribbon/movie/1    访问端口  
 * 
 * 
 * 集群监控：
 * 开启的服务：microservice-discovery-eureka，microservice-provider-user，microservice-comsumer-movie-ribbon-with-hystrix3，
 *         microservice-hystrix-turbine3，microservice-hystrix-dashboard
 * http://localhost:8010/ribbon/movie/1
 * http://localhost:8030/hystrix（http://localhost:8031/turbine.stream?cluster=MICROSERVICE-COMSUMER-MOVIE-RIBBON-WITH-HYSTRIX3）
 * 
 * Turbine Stream  自学部分
 */

@EnableTurbine
@SpringBootApplication
public class TurbineApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(TurbineApplication.class, args);
    }
}
