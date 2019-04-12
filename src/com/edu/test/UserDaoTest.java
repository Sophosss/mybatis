package com.edu.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.edu.bean.User;
import com.edu.dao.UserDao;
import com.edu.dao.UserDaolmpl;

public class UserDaoTest {
	
	private static SqlSessionFactory ssf;
	
	static {
		String resource = "sqlMapConfig.xml";
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			ssf = ssfb.build(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	@Test
	public void DaoTest() {
		UserDao dao = new UserDaolmpl(ssf);
		User user = dao.getUserById(1);
		System.out.println(user);
	}
}
