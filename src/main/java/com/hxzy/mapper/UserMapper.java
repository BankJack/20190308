package com.hxzy.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.FetchType;

import com.hxzy.entity.User;

/**
 * 使用mybatis  mapper代理的user
 * @author nick
 * 2019年3月8日
 *
 */
public interface UserMapper {
	
	/**
	 * 通过注解实现插入用户并返回主键到user对象中的id属性
	 * @param user 要插入的user对象
	 * @return 数据库受影响的行数
	 */
	@Insert("insert into `user` (`username`,`birthday`,`sex`,`address`) values (#{userName},#{birthday},#{sex},#{address})")
	@SelectKey(statement="SELECT LAST_INSERT_ID()",before=false,keyProperty="id" ,resultType=Integer.class)
	public int add(User user);
	
	@Update({"update `user` set `username` = #{userName},"
			+ "birthday=#{birthday},sex=#{sex},address=#{address} "
			+ " where `id` = #{id}"})
	public int update(User user);
	
	@Delete(value= {"delete from `user` where `id` = #{id}"})
	public int deleteById(Integer id);
	
	/**
	 * @Results 对应xml映射文件中的ResultMap节点
	 * 			id对应的是该ResultMap的id
	 * 			value中配置的是Result类型的数组
	 * @Result  配置ResultMap中的result节点
	 * 			id=true，说明该列为主键。
	 * @param id
	 * @return
	 */
	@Results(id="userResult",value= {
			@Result(column="id",property="id",id=true),
			@Result(column="username",property="userName"),
			@Result(column="birthday",property="birthday"),
			@Result(column="sex",property="sex"),
			@Result(column="address",property="address"),
			@Result(property="orders",javaType=ArrayList.class,column="id",many=@Many(
						fetchType=FetchType.LAZY,
						select="com.hxzy.mapper.OrdersMapper.queryOrdersByUserId"
					))
	})
	@Select("select * from `user` where `id` = #{id}")
	public User findById(Integer id);
	
	/**
	 * 为了复用已经定义好的Results,通过ResultMap注解中指定已经创建好的Results的id值进行复用
	 * @param userName
	 * @return
	 */
	@ResultMap("userResult")
	@Select("select * from `user` where `username` = #{userName}")
	public User findByName(String userName);
	
	@ResultMap("userResult")
	@Select("select * from `user`")
	public List<User> findAll();
	
	/**
	 * 如果有name不为空，则根据名字查询用户
	 * 如果name为空，则全查
	 * @param name
	 * @return
	 */
	@ResultMap("userResult")
	@SelectProvider(type=UserInner.class,method="queryUserSQL")
	public List<User> findByCondition(User user);
	
	static class UserInner{
		/**
		 * 组件动态SQL语句
		 */
		public static String queryUserSQL(User user) {
			return new SQL() {{
				SELECT("*");
				FROM("`user`");
				if (user.getUserName() != null && !user.getUserName().equals("")) {
					WHERE("username like \"%\"#{userName}\"%\""); //模糊查询
				}
				AND();
				WHERE("TIMESTAMPDIFF(YEAR,birthday,now()) >= 10 and TIMESTAMPDIFF(YEAR,birthday,now()) <= 18");
			}}.toString();
		}
	}
}
