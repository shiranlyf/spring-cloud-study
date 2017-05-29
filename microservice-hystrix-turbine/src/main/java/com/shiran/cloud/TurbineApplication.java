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
