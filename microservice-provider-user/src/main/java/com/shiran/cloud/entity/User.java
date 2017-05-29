package com.shiran.cloud.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户的实体类  
 * 这里需要进行序列化
 * @author shiran
 */
@Entity
public class User implements Serializable{
	
	//标识为id  增长模式设置为自动增长
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String username;
	@Column
	private String name;
	@Column
	private short age;
	@Column
	private BigDecimal balance;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
