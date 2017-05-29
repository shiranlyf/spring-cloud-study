package com.shiran.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.shiran.cloud.entity.User;
import com.shiran.cloud.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository  userRepository;
	
	//Using the EurekaClient  这里是spring eureka封装
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient  discoveryClient;
	
	/**
	 * @RequestMapping 相当与requestMapping的的使用
	 * 这个是一个混合注解
	 * @param id
	 * @return
	 */
	@GetMapping("/simple/{id}")
	public User getUserById(@PathVariable Long id){
		return this.userRepository.findOne(id);
	}
	
	
	/**
	 * 这个是EurekaClient对应的方法
	 * http://localhost:7900/eureka-instance  
	 * @return
	 */
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		//这里第一个参数要制定服务的  
	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
	    //对ip进行放回   result:http://192.168.1.144:7900/
	    return instance.getHomePageUrl();
	}
	
	
	/**
	 * 打印主机的配置信息
	 * 第二个eureka client的例子
	 * http://localhost:7900/eureka-info
	 * result:{"host":"192.168.1.144","port":7900,"metadata":{},"secure":false,
	 *       "uri":"http://192.168.1.144:7900","serviceId":"microservice-provider-user"}
	 */
	@GetMapping("/eureka-info")
	public ServiceInstance showInfo(){
		ServiceInstance  localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return   localServiceInstance;
	}
	
	
	/**
	 * 编写一个post的mapping
	 * @RequestBody 注解表示的请求体
	 */
	@PostMapping("/user")
	public User postUser(@RequestBody User user){
		return user;
	}
	
	//该请求不会成功
	@GetMapping("/get-user")
	public User getUser(User user){
		return user;
	}
	
	/**
	 * http://localhost:7900/list-all
	 * @return
	 */
	@GetMapping("/list-all")
	public List<User> getListAll(){
		List<User> list = new ArrayList<>();
		User user = new User(1L, "zhangsan1");
		User user2 = new User(2L, "zhangsan2");
		User user3 = new User(3L, "zhangsan3");
		User user4 = new User(4L, "zhangsan4");
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		return list;
	}
	
	
	
	

	
	
}
