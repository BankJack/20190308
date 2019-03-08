package com.hxzy.entity;

import java.util.Date;
import java.util.List;

/**
 * 订单
 * @author Administrator
 *
 */
public class Orders {

	private Integer id;
	private Integer userId;
	private String number;
	private Date createtime;
	private String note;
	
	//一个订单对应一个用户
	private User user;
	
	//一个订单对应多个订单明细  1:N
	private List<OrdersDetail> details;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public List<OrdersDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrdersDetail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number + ", createtime=" + createtime
				+ ", note=" + note + ", user=" + user + ", details=" + details + "]";
	}

	public Orders(Integer id, Integer userId, String number, Date createtime, String note, User user,
			List<OrdersDetail> details) {
		super();
		this.id = id;
		this.userId = userId;
		this.number = number;
		this.createtime = createtime;
		this.note = note;
		this.user = user;
		this.details = details;
	}

	public Orders() {
		super();
	}

	
	
}
