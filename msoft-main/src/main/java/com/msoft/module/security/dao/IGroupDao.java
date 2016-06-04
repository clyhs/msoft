package com.msoft.module.security.dao;

import java.io.Serializable;

import com.msoft.core.pojo.security.Group;

public interface IGroupDao {
	
	public int add(Group group);
	
	public Group getById(Serializable groupId);

}
