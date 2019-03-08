package com.hxzy.mapper.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hxzy.entity.Orders;
import com.hxzy.mapper.OrdersMapper;
import com.hxzy.util.SqlSessionFactoryInstance;

public class OrdersMapperImpl implements OrdersMapper {

	private SqlSessionFactory factory;
	public OrdersMapperImpl() {
		try {
			factory = SqlSessionFactoryInstance.getInstance().getSqlSessionFactory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Orders> queryAll() {
		SqlSession session = factory.openSession();
		try {
			OrdersMapper mapper = session.getMapper(OrdersMapper.class);
			return mapper.queryAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Orders> queryOrdersByUserId(Integer id) {
		SqlSession session = factory.openSession();
		try {
			OrdersMapper mapper = session.getMapper(OrdersMapper.class);
			return mapper.queryOrdersByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	

}
