package com.msoft.module.security.dao.impl;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.msoft.core.db.base.BaseDao;
import com.msoft.core.pojo.security.User;
import com.msoft.module.security.dao.IUserDao;

@Repository("UserDao")
@Scope("prototype")
public class UserDaoImpl extends BaseDao<User> implements IUserDao {

	public int add(User user) {
		// TODO Auto-generated method stub
		return super.insert(user);
	}

	public User getById(Serializable userId) {
		// TODO Auto-generated method stub
		return super.getById(userId);
	}

}
