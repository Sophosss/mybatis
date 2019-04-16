package com.edu.dao;

import com.edu.bean.User;

public interface UserDao {
	
	//根据id查询用户接口
	public User getUserById(Integer id);
}
