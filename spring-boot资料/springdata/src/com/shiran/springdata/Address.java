package com.shiran.springdata;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * entity表示声明一个实体
 * @Table 声明一个实体的名称
 * @author shiran 
 */

@Table(name = "JPA_ADDRESSES")
@Entity
public class Address {
	
	private Integer id;
	private String province;  //代表省
	private String city;  //代表市
	
	
	/**
	 * @GeneratedValue这个默认表示自动增长
	 * @return
	 */
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	

}
