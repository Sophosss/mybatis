package com.edu.mapper;

import java.util.List;

import com.edu.bean.Country;

public interface CountryMapper {

	//查询所有
	List<Country> selectAll(String name);
}
