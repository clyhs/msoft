package com.msoft.module.security.dao;

import java.io.Serializable;

import com.msoft.core.pojo.security.Role;

public interface IRoleDao {
	
	public int add(Role role);
	
	public Role getById(Serializable id);

}
