package com.edu.mapper;

import java.util.List;

import com.edu.bean.User;
import com.edu.bean.UserVo;

public interface UserMapper {
	
	//通过id查询用户,接口相关部分与userMapper.xml一致;方法名，形参，返回值，namespace全包名
	public User selectUserById(Integer id);	
	
	//通过用户名模糊查询
	public List<User> selectUserByName(String name);
	
	//添加用户
	public void insertUser(User user);
	
	//通过Vo查询
	public User selectUserByUserVoId(UserVo vo);
	
	//输出数据总数
	public Integer selectUserCount();
}
