package com.msoft.module.security.dao;

import java.io.Serializable;

import com.msoft.core.pojo.security.Tree;


public interface ITreeDao {
	
    public int add(Tree tree);
	
	public Tree getById(Serializable id);

}
