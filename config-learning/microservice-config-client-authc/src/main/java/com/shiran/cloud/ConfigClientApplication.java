package com.shiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Config client
 * 
 * 1.http://localhost:8081/profile    
 *    配置中已经制定application是foobar  profile是dev 这里指定属性名称进行查询
 */
@SpringBootApplication
public class ConfigClientApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
