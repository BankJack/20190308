package com.hxzy.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4975416270309660550L;
	private Integer id;
	private String userName;
	private Date birthday;
	private String sex;
	private String address;
	private List<Orders> orders;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + "]";
	}
	
}
