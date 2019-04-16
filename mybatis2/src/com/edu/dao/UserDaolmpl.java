package com.edu.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.edu.bean.User;

public class UserDaolmpl implements UserDao {

	//sqlSession工厂
	private SqlSessionFactory ssf;
	
	//构造器给ssf赋值
	public UserDaolmpl(SqlSessionFactory ssf) {
		super();
		this.ssf = ssf;
	}

	@Override
	public User getUserById(Integer id) {
				
				
		//生产sqlSession
		SqlSession session = ssf.openSession();
		
		//操作数据库
		return session.selectOne("UserMapper.selectUserById", id);

	}

}
