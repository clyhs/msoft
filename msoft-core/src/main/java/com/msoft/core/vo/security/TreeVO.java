package com.msoft.core.vo.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1329597470872999755L;

	private int id;
	
	private String text;
	
	private String icons;
	
	private String url;
	
	private boolean leaf;
	
	private boolean expanded;
	
	

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	private List<TreeVO> children = new ArrayList<TreeVO>();
	
	

	public List<TreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<TreeVO> children) {
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	

}
