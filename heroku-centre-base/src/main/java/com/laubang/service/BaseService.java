package com.laubang.service;

import java.util.List;

public abstract class BaseService<T> {
	
	public abstract List<T> selectAll();
	
	public abstract T selectByPrimaryKey(T entity);

	public abstract T insert(T entity);

	public abstract T update(T entity);
	
	public abstract void delete(T entity);
}
