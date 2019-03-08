package com.hxzy.mapper;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hxzy.entity.Orders;
import com.hxzy.entity.User;
import com.hxzy.mapper.impl.UserMapperImpl;

public class UserMapperTest {

	private UserMapper mapper;
	
	@Before
	public void setUp() {
		mapper = new UserMapperImpl();
	}
	
	@Test
	public void testAdd() {
		User user = new User();
		user.setUserName("欧欧");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("渝中区");
		int row = mapper.add(user);
		assertEquals(1, row);
	}
	
	@Test
	public void testFindById() {
		User user = mapper.findById(1);
		System.out.println(user);
		List<Orders> orders = user.getOrders();
		for (Orders orders2 : orders) {
			System.out.println(orders2);
		}
	}

	@Test
	public void testFindByName() {
		User user = mapper.findByName("欧欧");
		System.out.println(user);
		assertNotNull(user);
	}
	@Test
	public void testFindAll() {
		List<User> findAll = mapper.findAll();
		findAll.stream().forEach(System.out::println);
	}
	
	@Test
	public void testUpate() {
		User user = new User();
		user.setId(16);
		user.setUserName("娜娜");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("南岸区");
		int row = mapper.update(user);
		assertEquals(1, row);
	}
	
	@Test
	public void testDeleteById() {
		int row = mapper.deleteById(3);
		assertEquals(1, row);
	}
	
	@Test
	public void testFindByCondition() {
		User user = new User();
		user.setUserName("花");
		List<User> list = mapper.findByCondition(user);
		for (User u : list) {
			System.out.println(u);
		}
	}
}
