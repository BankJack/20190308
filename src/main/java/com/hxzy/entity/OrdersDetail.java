package com.hxzy.entity;

import java.io.Serializable;

public class OrdersDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4053519886632648803L;

	private Integer id;
	private Integer ordersId;
	private Integer itemId;
	private Integer itemNum;
	
	//多个订单明细对应一个订单   N:1
	private Orders orders;
	
	//一个订单明细对应一条商品信息   1:1
	private Item item;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getItemNum() {
		return itemNum;
	}
	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "OrdersDetail [id=" + id + ", ordersId=" + ordersId + ", itemId=" + itemId + ", itemNum=" + itemNum
				+ ", orders=" + orders + ", item=" + item + "]";
	}
	public OrdersDetail(Integer id, Integer ordersId, Integer itemId, Integer itemNum, Orders orders, Item item) {
		super();
		this.id = id;
		this.ordersId = ordersId;
		this.itemId = itemId;
		this.itemNum = itemNum;
		this.orders = orders;
		this.item = item;
	}
	public OrdersDetail() {
		super();
	}
	
	
}
