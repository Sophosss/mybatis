package com.edu.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.edu.bean.User;


public class HeMybatis {
	@Test
	//ID查询
	public void Test1() throws IOException {
		//读取配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);

		//需要sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		
		//操作数据库
		User user = session.selectOne("UserMapper.selectUserById", 1);
		System.out.println(user);
		
	}
	@Test
	public void Test2() throws IOException {
		//读取配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);

		//需要sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		
		//操作数据库
		List<User> list = session.selectList("UserMapper.selectUserByName","王");
		for (User u : list) {
			System.out.println(u);
		}
	}
	@Test
	public void Test3() throws IOException {
		//读取配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);

		//需要sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		
		//操作数据库
		User user = new User();
		user.setU_id(13);
		user.setU_username("球球");
		user.setU_password("1234");
		user.setU_sex("1");
		user.setU_createTime(new Date(1));
		user.setU_cid(1);
		
		session.insert("UserMapper.insertUser", user);
		session.commit();
		
	}
	
	@Test
	public void Test4() throws IOException {
		//读取配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);

		//需要sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		
		//操作数据库
		User user = new User();
		user.setU_id(13);
		user.setU_username("球球球");
				
		session.update("UserMapper.updateUser", user);
		session.commit();
	}
	
	@Test
	public void Test5() throws IOException {
		//读取配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);

		//需要sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = ssfb.build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		
		//操作数据库
					
		session.delete("UserMapper.deleteUserById", 14);
		session.commit();
	}
}
