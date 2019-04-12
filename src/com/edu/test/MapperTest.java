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

import com.edu.bean.Country;
import com.edu.bean.User;
import com.edu.bean.UserVo;
import com.edu.mapper.CountryMapper;
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
		User user = mapper.selectUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void Test2() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectUserByName("老");
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void Test3() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setU_id(15);
		user.setU_username("球宝宝");
		user.setU_password("1234");
		user.setU_sex("1");
		user.setU_createTime(new Date(1));
		user.setU_cid(1);
		mapper.insertUser(user);
		session.commit();
		
	}
	
	@Test
	public void Test_selectUserByUserVoId() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserVo vo = new UserVo();
		User u = new User();
		u.setU_id(2);
		vo.setUser(u);
		
		User user = mapper.selectUserByUserVoId(vo);
		System.out.println(user);
	}
	
	@Test
	public void Test_selectUserCount() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer count = mapper.selectUserCount();
		System.out.println(count);
	}
	
	@Test
	public void Test_selectAll() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建sqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产sqlSession
		SqlSession session = ssf.openSession();
		CountryMapper mapper = session.getMapper(CountryMapper.class);
		List<Country> list = mapper.selectAll("北京");
		for (Country country : list) {
			System.out.println(country);
		}
	}
}
