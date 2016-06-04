package com.msoft.core.pojo.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="TS_TREE")
public class Tree implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8051432675014551046L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "N_TREE_ID")
	private int NTreeId;
	
	@Column(name = "N_TREE_NAME")
	private String STreeName;
	
	@Column(name = "S_URL")
	private String SUrl;
	
	@Column(name = "S_ICON")
	private String SIcon;
	
	@Column(name = "B_LEAF")
	private Boolean BLeaf;
	
	@Column(name = "B_SHOW")
	private Boolean BShow;
	
	@ManyToOne
	private Tree OParent;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "OParent")
	@OrderBy("N_TREE_ID DESC")
	private List<Tree> children = new ArrayList<Tree>();
	
	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "ATrees", fetch = FetchType.LAZY)
    protected List<User> AUsers=new ArrayList<User>();
	
	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "ATrees", fetch = FetchType.LAZY)
    protected List<Role> ARoles=new ArrayList<Role>();
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "TS_TREE_POWER", joinColumns = {
    @JoinColumn(name = "N_TREE_ID")}, inverseJoinColumns = {
    @JoinColumn(name = "N_POWER_ID")})
    protected List<Power> APowers = new ArrayList<Power>();
	
	
	
	public List<Power> getAPowers() {
		return APowers;
	}
	public void setAPowers(List<Power> aPowers) {
		APowers = aPowers;
	}
	@JsonIgnore 
	public List<Role> getARoles() {
		return ARoles;
	}
	public void setARoles(List<Role> aRoles) {
		ARoles = aRoles;
	}
	@JsonIgnore 
	public Tree getOParent() {
		return OParent;
	}
	public void setOParent(Tree oParent) {
		OParent = oParent;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	@JsonIgnore 
	public List<User> getAUsers() {
		return AUsers;
	}
	public void setAUsers(List<User> aUsers) {
		AUsers = aUsers;
	}
	public int getNTreeId() {
		return NTreeId;
	}
	public void setNTreeId(int nTreeId) {
		NTreeId = nTreeId;
	}
	public String getSTreeName() {
		return STreeName;
	}
	public void setSTreeName(String sTreeName) {
		STreeName = sTreeName;
	}
	public String getSUrl() {
		return SUrl;
	}
	public void setSUrl(String sUrl) {
		SUrl = sUrl;
	}
	public String getSIcon() {
		return SIcon;
	}
	public void setSIcon(String sIcon) {
		SIcon = sIcon;
	}
	public Boolean getBLeaf() {
		return BLeaf;
	}
	public void setBLeaf(Boolean bLeaf) {
		BLeaf = bLeaf;
	}
	public Boolean getBShow() {
		return BShow;
	}
	public void setBShow(Boolean bShow) {
		BShow = bShow;
	}
	
	
	
	
	
	

}
