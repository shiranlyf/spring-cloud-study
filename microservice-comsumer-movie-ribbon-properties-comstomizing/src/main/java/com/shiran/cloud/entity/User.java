package com.shiran.cloud.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 这个使用的实体类   去掉jpa的注解
 * @author shiran
 */

public class User implements Serializable{
	
	private long id;
	private String username;
	private String name;
	private short age;
	private BigDecimal balance;
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
