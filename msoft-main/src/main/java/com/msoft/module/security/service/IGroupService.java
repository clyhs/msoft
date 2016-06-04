package com.msoft.module.security.service;

import java.io.Serializable;

import com.msoft.core.pojo.security.Group;


public interface IGroupService {
public int add(String name);
	
	public Group getById(Serializable groupId);

}
