package com.msoft.module.security.dao.impl;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.msoft.core.db.base.BaseDao;
import com.msoft.core.pojo.security.Group;
import com.msoft.module.security.dao.IGroupDao;


@Repository("GroupDao")
@Scope("prototype")
public class GroupDaoImpl extends BaseDao<Group> implements IGroupDao {

	public int add(Group group) {
		// TODO Auto-generated method stub
		return super.insert(group);
	}

	public Group getById(Serializable groupId) {
		// TODO Auto-generated method stub
		return super.getById(groupId);
	}

}
