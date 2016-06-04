package com.msoft.module.security.service;

import java.io.Serializable;
import java.util.List;

import com.msoft.core.pojo.security.Group;
import com.msoft.core.pojo.security.User;

public interface IUserService {
	
	public int add(String name,List<Group> groups);
	
	public User getById(Serializable userId);

}
