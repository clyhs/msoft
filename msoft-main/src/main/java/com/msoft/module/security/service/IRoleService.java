package com.msoft.module.security.service;

import java.io.Serializable;

import com.msoft.core.pojo.security.Role;

public interface IRoleService {
	
	public int add(String name,Role parent);
	
	public Role getById(Serializable pk);

}
