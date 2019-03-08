package com.hxzy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.hxzy.entity.Orders;
import com.hxzy.entity.User;

/**
 * OrdersMapper继承基类
 */
public interface OrdersMapper{
	/**
	 * @Options 配置查询相关的属性  useCache=true 开启二级缓存
	 * Result中的one代表配置N:1  多个订单对应一个用户
	 * Result中的many配置1:N
	 * @return
	 */
	@Options(useCache=true)
	@Results(id="ordersResultMap",value= {
			@Result(column="id",property="id",id=true),
			@Result(column="user_id",property="userId"),
			@Result(column="number",property="number"),
			@Result(column="createtime",property="createtime"),
			@Result(column="note",property="note"),
			@Result(property="user",javaType=User.class,column="user_id",one=@One(
					select="com.hxzy.mapper.UserMapper.findById",fetchType=FetchType.LAZY
					)
			)
	})
	@Select("select * from orders")
	public List<Orders> queryAll();
	
	@Results(id="ordersResultMap2",value= {
			@Result(column="id",property="id",id=true),
			@Result(column="user_id",property="userId"),
			@Result(column="number",property="number"),
			@Result(column="createtime",property="createtime"),
			@Result(column="note",property="note"),
	})
	@Select("select * from orders where user_id = #{id}")
	public List<Orders> queryOrdersByUserId(Integer id);
}