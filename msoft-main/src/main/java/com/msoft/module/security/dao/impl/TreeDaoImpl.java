package com.msoft.module.security.dao.impl;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.msoft.core.db.base.BaseDao;
import com.msoft.core.pojo.security.Tree;
import com.msoft.module.security.dao.ITreeDao;

@Repository("TreeDao")
@Scope("prototype")
public class TreeDaoImpl extends BaseDao<Tree> implements ITreeDao {

	public int add(Tree tree) {
		// TODO Auto-generated method stub
		return super.insert(tree);
	}

	public Tree getById(Serializable id) {
		// TODO Auto-generated method stub
		return super.getById(id);
	}

}
