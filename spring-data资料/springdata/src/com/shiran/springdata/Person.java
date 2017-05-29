package com.shiran.springdata;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "JPA_PERSONS")
@Entity
public class Person {
	
	private Integer id;
	private String lastName;
	private String email;
	private Date birth;
	
	private Address address;
	
	//address中对应的还有一个id -addressId
	private Integer addressId;
	
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * 在数据库进行映射的时候进行重命名
	 * @return
	 */
	@Column(name = "ADD_ID")
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * ADDRESS_ID：这个设置的关联的外键的属性
	 * @return
	 */
	@JoinColumn(name = "ADDRESS_ID")
	@ManyToOne
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", email=" + email + ", birth=" + birth + "]";
	}
	
	
	

}
