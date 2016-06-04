package com.msoft.module.security.dao.impl;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.msoft.core.db.base.BaseDao;
import com.msoft.core.db.hibernate.DaoImpl;
import com.msoft.core.pojo.security.Role;
import com.msoft.module.security.dao.IRoleDao;

@Repository("RoleDao")
@Scope("prototype")
public class RoleDaoImpl extends BaseDao<Role> implements IRoleDao {

	public int add(Role role) {
		// TODO Auto-generated method stub
		return super.insert(role);
	}

	public Role getById(Serializable id) {
		// TODO Auto-generated method stub
		return super.getById(id);
	}

	
	
	
	
	

}
