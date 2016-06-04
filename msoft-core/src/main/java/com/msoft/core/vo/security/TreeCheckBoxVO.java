package com.msoft.core.vo.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeCheckBoxVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2239258283668162553L;
	
    private int id;
	
	private String text;
	
	private String icons;
	
	private String url;
	
	private boolean leaf;
	
	private boolean expanded;
	
	private boolean checked;
	
	private List<TreeCheckBoxVO> children = new ArrayList<TreeCheckBoxVO>();
	
	

	public List<TreeCheckBoxVO> getChildren() {
		return children;
	}

	public void setChildren(List<TreeCheckBoxVO> children) {
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

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	

}
