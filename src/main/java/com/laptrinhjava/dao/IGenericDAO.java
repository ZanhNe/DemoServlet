package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.mapper.RowMapper;

public interface IGenericDAO<T> {
	List<T> query(String sql, RowMapper<T> t, Object... objects);
	
	int count(String sql, Object...objects);

	void update(String sql, Object... objects);
	
	int insert(String sql, Object... objects);
	
	

}
