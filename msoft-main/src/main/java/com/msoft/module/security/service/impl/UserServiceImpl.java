package com.msoft.module.security.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.msoft.core.pojo.security.Group;
import com.msoft.core.pojo.security.User;
import com.msoft.module.security.dao.IUserDao;
import com.msoft.module.security.service.IUserService;


@Service(value="UserService")
public class UserServiceImpl implements IUserService {
	
	@Resource(name = "UserDao")	
	private IUserDao m_oUserDao;

	public int add(String name,List<Group> groups) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setSUserName(name);
		if(groups!=null && groups.size()>0){
			user.setAGroups(groups);
		}
		return m_oUserDao.add(user);
	}

	public User getById(Serializable userId) {
		// TODO Auto-generated method stub
		return m_oUserDao.getById(userId);
	}

}
