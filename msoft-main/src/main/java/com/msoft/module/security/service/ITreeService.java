package com.msoft.module.security.service;

import java.io.Serializable;

import com.msoft.core.pojo.security.Tree;
import com.msoft.core.vo.security.TreeVO;

public interface ITreeService {
	
    public int add(String name,String url,String icon,
    		Boolean isleaf,Boolean isshow,
    		Tree parent);
	
	public Tree getById(Serializable treeId);
	
	public TreeVO getAllTree();

}
