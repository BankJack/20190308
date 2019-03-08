package com.hxzy.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 单例模式
 * 通过内部类的形式实现的单例模式
 * @author Administrator
 *
 */
public class SqlSessionFactoryInstance {
	private SqlSessionFactoryInstance() {}
	
	private static class SingletonInstance{
		private static final SqlSessionFactoryInstance instance = new SqlSessionFactoryInstance();
	}
	
	public static SqlSessionFactoryInstance getInstance() {
		return SingletonInstance.instance;
	}
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory;
	}
	
}
