package com.shiran.springdata;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * base-package="com.shiran.springdata"下进行扫描实现类
 * @author shiran
 *
 */
public class PersonRepositoryImpl implements PersonDao{

	//与jpa原生的访问进行打通
	@PersistenceContext
	private EntityManager  entityManager;
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		Person person = entityManager.find(Person.class, 11);
		System.out.println("----->" + person);
	}

}
