package com.edu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.edu.bean.User;
import com.edu.bean.UserExample;
import com.edu.mapper.UserMapper;

public class MapperTest {
	
	@Test
	public void Test1() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
//		UserExample userExample = new UserExample();
//		userExample.createCriteria().andUSexEqualTo("0");
//		List <User> users = mapper.selectByExample(userExample);
//		for (User user : users) {
//			System.out.println(user);
//		}
		
//		User user = mapper.selectByPrimaryKey(2);
//		System.out.println(user);
		
		User user = new User();
		user.setuUsername("小龙");
		mapper.insertSelective(user);
		session.commit();
	}
	
}
