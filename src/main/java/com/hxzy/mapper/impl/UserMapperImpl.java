package com.hxzy.mapper.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hxzy.entity.User;
import com.hxzy.mapper.UserMapper;
import com.hxzy.util.SqlSessionFactoryInstance;

public class UserMapperImpl implements UserMapper {

	private SqlSessionFactory factory;
	public UserMapperImpl() {
		try {
			factory = SqlSessionFactoryInstance.getInstance().getSqlSessionFactory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int add(User user) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			int row = mapper.add(user);
			System.out.println("数据库主键：" + user.getId());
			session.commit();
			return row;
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int update(User user) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			int row = mapper.update(user);
			session.commit();
			return row;
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			int row = mapper.deleteById(id);
			session.commit();
			return row;
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public User findById(Integer id) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			return mapper.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			return mapper.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public User findByName(String userName) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			return mapper.findByName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<User> findByCondition(User user) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			return mapper.findByCondition(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
