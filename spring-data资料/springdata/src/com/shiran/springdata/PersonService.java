package com.shiran.springdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在service层进行注解的开发
 * @author shiran 
 *
 */

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository  personRepository;
	
	
	
	@Transactional
	public void savePersons(List<Person> persons){
		personRepository.save(persons);
	}
	
	
	/**
	 * 在service层进行实物的注解
	 * 要在applicationContext.xml中添加自动扫描的功能
	 *   <!-- 添加对service层的包进行自动扫描的功能  对指定的包进行扫描-->
     *   <context:component-scan base-package="com.shiran.springdata"></context:component-scan>
	 * @param id
	 * @param email
	 */
	@Transactional
	public void updatePersonEmail(Integer id, String email){
	    personRepository.updatePersonEmail(id, email);
	}

}
