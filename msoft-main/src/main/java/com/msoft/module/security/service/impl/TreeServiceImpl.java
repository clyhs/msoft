package com.msoft.module.security.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.msoft.core.db.base.BaseDao;
import com.msoft.core.pojo.security.Tree;
import com.msoft.core.vo.security.TreeVO;
import com.msoft.module.security.dao.IGroupDao;
import com.msoft.module.security.dao.ITreeDao;
import com.msoft.module.security.service.ITreeService;

@Service(value="TreeService")
public class TreeServiceImpl extends BaseDao<Tree> implements ITreeService {
	
	@Resource(name = "TreeDao")	
	private ITreeDao m_oTreeDao;

	public int add(String name,String url,String icon,
    		Boolean isleaf,Boolean isshow,
    		Tree parent) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.setSTreeName(name);
		tree.setSUrl(url);
		tree.setSIcon(icon);
		tree.setBLeaf(isleaf);
		tree.setBShow(isshow);
		if(parent!=null){
			tree.setOParent(parent);
		}
		return m_oTreeDao.add(tree);
	}

	public Tree getById(Serializable treeId) {
		// TODO Auto-generated method stub
		return m_oTreeDao.getById(treeId);
	}
	
	public TreeVO getAllTree(){
		
		Tree root = m_oTreeDao.getById(1);
		TreeVO rootVO = new TreeVO();
		rootVO.setId(root.getNTreeId());
		rootVO.setText(root.getSTreeName());
		rootVO.setIcons(root.getSIcon());
		rootVO.setLeaf(root.getBLeaf());
		rootVO.setUrl(root.getSUrl());
		
		buildTreeVo(root,rootVO);
		return rootVO;
	}
	
	private void buildTreeVo(Tree tree,TreeVO treeVo){
		List<TreeVO> childrens = new ArrayList<TreeVO>();
		if(tree.getChildren().size()>0){
			treeVo.setExpanded(Boolean.TRUE);
			for(int i=0 ;i <tree.getChildren().size();i++){
				TreeVO child = new TreeVO();
				Tree   t = tree.getChildren().get(i);
				child.setId(t.getNTreeId());
				child.setText(t.getSTreeName());
				child.setLeaf(t.getBLeaf());
				child.setIcons(t.getSIcon());
				child.setUrl(t.getSUrl());
				childrens.add(child);
				if(t.getChildren().size()>0){
					buildTreeVo(t,child);
				}
				
			}
			treeVo.setChildren(childrens);
			
		}
		
	}

}
