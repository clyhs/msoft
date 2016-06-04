package com.msoft.module.security.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.msoft.core.pojo.security.Group;
import com.msoft.module.security.dao.IGroupDao;
import com.msoft.module.security.dao.IUserDao;
import com.msoft.module.security.service.IGroupService;

@Service(value="GroupService")
public class GroupServiceImpl implements IGroupService {

	@Resource(name = "GroupDao")	
	private IGroupDao m_oGroupDao;
	
	public int add(String name) {
		// TODO Auto-generated method stub
		Group group = new Group();
		group.setSGroupName(name);
		return m_oGroupDao.add(group);
	}

	public Group getById(Serializable groupId) {
		// TODO Auto-generated method stub
		return m_oGroupDao.getById(groupId);
	}

}
