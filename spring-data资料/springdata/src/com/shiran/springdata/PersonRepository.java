package com.shiran.springdata;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * 第二个参数指的是主键的类型
 * @author shiran
 * 
 * Repository是一个空接口：将代码source的common导入到进来就可以
 * 1.它里面继承的也是一个空接口Serializable  实现这个空接口的话  这个类就可以进行序列化和反序列化
 * 2.我们编写的接口实现了Repository接口的时候，就会IOC容器识别为一个Repository bean 纳入到IOC容器中
 *   进而可以定义一定规范的代码
 * 3.声明的方法需要满足一定的条件
 * 
 * repository的神奇的地方：
 * 1.repository是一个标记接口   是一个实现了Serializable接口的接口
 * 2.成为repository bean容器的两个条件
 *   2.1 在applicationContext.xml中配置这个类在这个包下的repository扫描
 *   2.2 实现Repository接口
 *   就可以识别为spring data的repository的bean对象
 * 3.也可以用这个@RepositoryDefinition(domainClass = Person.class, idClass = Integer.class)进行替换
 * 
 * 1.可以通过ctrl + t查看repository的子接口
 * 
 * 2.repository子接口方法声明的规范：
 *  1.查询  read|get|find开头，条件查询用关键字连接，条件属性一首字母大写 getByLastName
 *  
 * 3.支持属性的级联查询
 * 
 * 4.优先使用当前类的属性   而不是级联类的属性 要使用级联数据时需要用_进行
 * 
 * 
 * repository是一个空接口
 * CrudRepository是一个repository的子接口：这个借口中定义了许多数据库操作的方法
 * 
 * PagingAndSortingRepository是CrudRepository的一个子接口
 * JpaRepository<T, ID extends Serializable>是PagingAndSortingRepository的子接口
 * 
 * 
 * JpaSpecificationExecutor：使用这个子接口进行动态条件的查询
 * 
 */
//public interface PersonRepository extends Repository<Person, Integer>{
//public interface PersonRepository extends CrudRepository<Person, Integer>{
//public interface PersonRepository extends PagingAndSortingRepository<Person, Integer>{

//JpaSpecificationExecutor值需要进行一个实体Person的传入  里面可以自定义自己的查询条件
public interface PersonRepository extends JpaRepository<Person, Integer>,JpaSpecificationExecutor<Person>, PersonDao{


	//根据lastName获取Person对象
	Person getByLastName(String lastName);
	
	//WHERE lastName LIKE ?% AND id < ?  以声明开始
	List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, Integer id);
	
	//WHERE lastName LIKE %? AND id < ? 以声明结束
    List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, Integer id);
	
    //WHERE email IN (?,?,?) OR birth < ?
    List<Person> getByEmailInOrBirthLessThan(List<String> emails, Date birth);
    
    //WHERE email IN (?,?,?) AND birth < ?
    List<Person> getByEmailInAndBirthLessThan(List<String> emails, Date birth);
    
    
    //WHERE a.id > ? 指定id的大小进行查询   查询比这个id大的所有的对象
    //getByIdGreaterThan这个表示的person的id的条件 
    //_表示的是使用级联表属性  否则为被类属性
    List<Person> getByAddress_IdGreaterThan(Integer id);
    
    //查询id值最大的person
    /**
     * @Query:可以自定义JPQL更灵活的语句
     * @return
     */
    @Query("SELECT p FROM Person p WHERE p.id = (SELECT max(p2.id) FROM Person p2)")
    Person getMaxIdPerson();
    
    /**
     * 使用占位符进行参数的传递
     */
    @Query("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2")
    List<Person> testQueryAnnotationParam1(String lastName, String email);
    
    /**
     * 使用参数命名的方式
     */
    @Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
    List<Person> testQueryAnnotationParam2(@Param("email") String email, @Param("lastName") String lastName);
    
    
    //模糊查询
    @Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% OR p.email LIKE %?2% ")
    List<Person> testQueryAnnotationParam(String lastName, String email);
    
    //nativeQuery = true 使用原生sql
    @Query(value = "SELECT count(id) FROM jpa_persons", nativeQuery = true)
    long getTotalCount();
    
    //JPQL不支持添加
    /**
     * 添加modify注解的时候才可以进行更新
     * 可以自定义JPQL完成UPDATE 和 DELETE操作  不能完成INSERT操作
     * 在@Query注解上面通过@Modifying 通知springdata 这是一个delete或update操作
     * update和delete需要添加事物的操作   需要添加service层  然后进行方法的事物注解
     * 有默认的事物  但只有只读功能
     * @param id
     * @param email
     */
    @Modifying
    @Query("UPDATE Person p SET p.email = :email WHERE p.id = :id")
    void updatePersonEmail(@Param("id") Integer id, @Param("email") String email);
    
    
}
