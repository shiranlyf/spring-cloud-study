package com.shiran.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import com.shiran.springdata.Person;
import com.shiran.springdata.PersonRepository;
import com.shiran.springdata.PersonService;

/**
 * spring data测试类
 * 
 * 
 * 
 * 
 * @author 释然
 *
 */
public class SpringDataTest {

	// 上下文对象
	private ApplicationContext ctx = null;

	private PersonRepository personRepository = null;
	
	private PersonService  personService;

	{
		// 根据xml文件生成对应的上下文对象
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		personRepository = ctx.getBean(PersonRepository.class);
		personService = ctx.getBean(PersonService.class);

	}
	
	
	/**
	 * 自定义Repository
	 */
	@Test
	public void definedRepository(){
		 personRepository.test();
    }
	
	/**
	 * 实现待查询条件的分页  id > 5
	 * findAll(Specification<T>, Pageable)
	 * Specification封装了jpa Critiria的查询条件
	 * Pageable：封装了请求分页的信息
	 */
	@Test
	public void testJpaSpecificationExecutor(){
		//这里pageNo是从0开始计数的
		int pageNo = 3 - 1;
		int pageSize = 5;
		PageRequest pageable = new PageRequest(pageNo, pageSize);
		
		//通常使用Specification的匿名内部类进行实现
		//这里面可以进行导航到属性 进行查询条件的添加
		Specification<Person> specification = new  Specification<Person>() {
			
			/**
			 * root:代表查询的实体类
			 * query:可以从中得到root对象， 即告知JPA Critiaria查询要查询哪一个实体类，还可以添加查询条件
			 *  还可以结合EntityManager对象得到最终需要进行查询的TypedQuery对象
			 * cb:CriteriaBuilder对象   用于创建Critiria相关对象的工厂   所以可以得到Predicate对象
			 * return: Predicate代表的是返回值 代表一个查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				//通过root进行路径导航  这里指定的是id
				Path path = root.get("id");
				//这里指定的是 id > 5
				Predicate  predicate = cb.gt(path, 5);
				
				return  predicate;
			}
		};
		
		Page<Person> page = personRepository.findAll(specification, pageable);
		
		//进行相关信息的打印
		OutPutfenyeInfo(page);
	}
	
	
	//jpaRepository的测试  insert
	@Test
	public void testJpaRepository(){
	   Person   person = new Person();
	   person.setBirth(new Date());
	   person.setEmail("hello@qq.com");
	   person.setLastName("xyz");
	   
	   //因为这里没有id  所以这里进行insert操作
	   personRepository.saveAndFlush(person);
	}
	
	    /**
	     * jpaRepository的测试  相当于jpa中的merge方法
	     * 先执行select --> merge 
	     */
		@Test
		public void testJpaMerge(){
		   Person   person = new Person();
		   person.setBirth(new Date());
		   person.setEmail("shriano@qq.com");
		   person.setLastName("shrian");
		   person.setId(27);
		   
		   //因为这里没有id  所以这里进行insert操作
		   Person person2 = personRepository.saveAndFlush(person);
		   //两个对象不一样
		   System.out.println(person == person2);
		}
	

	@Test
	public void testPagingAndSortingRepository(){
		//这个是从0开始   所以-1
		int pageNo = 3 -1; //第几页
		int pageSize = 5; //每页的大小
		//这个对象就封装了分页的信息page, size PageRequest是Pageable的实现类   对分页的信息进行封装
		
		//进行排序相关的操作   这里id的顺序和email的顺序是一样的  
		//Order是对某一个字段进行具体的升序和降序的操作
		Order  order1 = new Order(Direction.DESC, "id");
		Order  order2 = new Order(Direction.ASC, "email");
		Sort sort = new Sort(order1, order2);
		
		PageRequest  pageable = new PageRequest(pageNo, pageSize, sort);
		Page<Person> page = personRepository.findAll(pageable);
		
		OutPutfenyeInfo(page);
		
	
	}
	
	public  void OutPutfenyeInfo(Page<Person> page){
		//得到总的记录数
		System.out.println("总的记录数" + page.getTotalElements());
	    System.out.println("当前的页码" + (page.getNumber() + 1));
	    System.out.println("总的页数" + page.getTotalPages());
	    System.out.println("当前页的list集合" + page.getContent());
	    System.out.println("当前页面的记录数" + page.getNumberOfElements());
	}
	
	/**
	 * 对指定字段进行修改的方法
	 */
	@Test
	public void testModifying(){
		personService.updatePersonEmail(1, "update@qq.com");
	}
	
	@Test
	public void getTotalCount(){
		long count = personRepository.getTotalCount();
		System.out.println(count);
	}
	
	@Test
	public void testQueryAnnotationParam(){
		List<Person> persons = personRepository.testQueryAnnotationParam("shi", "an@qq.com");
		System.out.println(persons);
	}
	
	
	@Test
	public void testQueryAnnotation(){
		Person person = personRepository.getMaxIdPerson();
		System.out.println(person);
	}
	
	@Test
	public void testQueryAnnotationParam1(){
		List<Person> persons = personRepository.testQueryAnnotationParam1("shiran", "shiran@qq.com");
		System.out.println(persons);
	}
	
	@Test
	public void testQueryAnnotationParam2(){
		List<Person> persons = personRepository.testQueryAnnotationParam2("shiran@qq.com", "shiran");
		System.out.println(persons);
	}

	@Test
	public void testKeyWords() {
		List<Person> persons = personRepository.getByLastNameStartingWithAndIdLessThan("sh", 3);
		// System.out.println(persons);

		persons = personRepository.getByLastNameEndingWithAndIdLessThan("ran", 3);
		// System.out.println(persons);

		persons = personRepository.getByEmailInOrBirthLessThan(
				Arrays.asList("34343@qq.com", "hello@qq.com", "shiran@qq.com"), new Date());
		// System.out.println(persons);

		persons = personRepository.getByEmailInAndBirthLessThan(
				Arrays.asList("34343@qq.com", "hello@qq.com", "shiran@qq.com"), new Date());
		System.out.println(persons);

	}


	/*
	 * 
	 * 支持属性的级联查询
	 * Hibernate: 
	    select
	        person0_.id as id1_1_,
	        person0_.address_id as address_5_1_,
	        person0_.birth as birth2_1_,
	        person0_.email as email3_1_,
	        person0_.last_name as last_nam4_1_ 
	    from
	        jpa_persons person0_ 
	    left outer join
	        jpa_addresses address1_ 
	            on person0_.address_id=address1_.id 
	    where
	        address1_.id>?
	[]
*/
	@Test
	public void testKeyWords2() {
		List<Person> persons = personRepository.getByAddress_IdGreaterThan(1);
		System.out.println(persons);
	}

	@Test
	public void testSpringData() {
		// personRepository是一个代理对象
		System.out.println(personRepository.getClass().getName());
		Person person = personRepository.getByLastName("shiran");
		System.out.println(person);
	}

	/**
	 * 测试entityMannager时候已经配置成功 执行这个方法的时候就会ctx的初始化
	 * 根据applitionContext.xml中entityManagerFactory的配置进行bean实体的扫描 生成对应的数据表
	 * 运行这个空的方法进行表的初始化 进行数据表之间的生成操作
	 * 
	 */
	@Test
	public void testjpa() {

	}

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		// 将连接进行打印出来
		System.out.println("这是我打印的信息" + dataSource.getConnection());
	}
	
	
	/**
	 * 方法
	 */
	@Test
	public void testSaves(){
		List<Person> persons = new ArrayList<>();
		for (int i = 'a'; i < 'z'; i++) {
			Person person = new Person();
			person.setAddressId(i + 1);
			person.setBirth(new Date());
			person.setEmail((char)i + "" + (char)i + "@qq.com");
			person.setLastName((char)i + "" + (char)i);
			persons.add(person);
		}
		personService.savePersons(persons);
	}

}
