package com.hxzy.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hxzy.entity.Orders;
import com.hxzy.mapper.impl.OrdersMapperImpl;

public class OrdersMapperTest {

	private OrdersMapper mapper;
	
	@Before
	public void setUp() {
		mapper = new OrdersMapperImpl();
	}
	
	@Test
	public void testQueryAll() {
		List<Orders> list = mapper.queryAll();
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}

}
