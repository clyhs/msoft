package com.msoft.module.security.dao;

import java.io.Serializable;

import com.msoft.core.pojo.security.User;

public interface IUserDao {
	
	public int add(User user);
	
	public User getById(Serializable userId);

}
