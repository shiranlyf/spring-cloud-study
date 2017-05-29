package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
/**
 * turbine:
 * 
 * turbine.stream:http://localhost:8031/turbine.stream
 * 
 * 
 * 
 * http://localhost:8030/hystrix中  --->http://localhost:8031/turbine.stream?cluster=MICROSERVICE-COMSUMER-MOVIE-RIBBON-WITH-HYSTRIX2
 * 
 *
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
