package com.msoft.module.security.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msoft.core.pojo.security.Role;
import com.msoft.module.security.dao.IRoleDao;
import com.msoft.module.security.service.IRoleService;

@Service(value="RoleService")
public class RoleServiceImpl implements IRoleService {
	
	@Resource(name = "RoleDao")
	private IRoleDao m_oRoleDao;

	public int add(String name, Role parent) {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setSRoleName(name);
		if(parent!=null){
			role.setOParent(parent);
		}
		return m_oRoleDao.add(role);
	}

	public Role getById(Serializable pk) {
		// TODO Auto-generated method stub
		return m_oRoleDao.getById(pk);
	}

}
