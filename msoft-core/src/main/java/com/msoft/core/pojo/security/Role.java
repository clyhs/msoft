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
@Table(name="TS_ROLE")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7532164174330710470L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "N_ROLE_ID")
	private int NRoleId;
	@Column(name = "S_ROLE_NAME")
	private String SRoleName;
	@ManyToOne
	private Role OParent;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "OParent")
	@OrderBy("N_ROLE_ID DESC")
	private List<Role> children = new ArrayList<Role>();
	
	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "ARoles", fetch = FetchType.LAZY)
    protected List<User> AUsers=new ArrayList<User>();
	
	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "ARoles", fetch = FetchType.LAZY)
    protected List<Group> AGroups = new ArrayList<Group>();
	
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "TS_ROLE_TREE", joinColumns = {
    @JoinColumn(name = "N_ROLE_ID")}, inverseJoinColumns = {
    @JoinColumn(name = "N_TREE_ID")})
    protected List<Tree> ATrees = new ArrayList<Tree>();
	
	
	
	
	public List<Tree> getATrees() {
		return ATrees;
	}

	public void setATrees(List<Tree> aTrees) {
		ATrees = aTrees;
	}

	/*防止 @ResponseBody时出现死循环*/
	@JsonIgnore
	public List<Group> getAGroups() {
		return AGroups;
	}

	public void setAGroups(List<Group> aGroups) {
		AGroups = aGroups;
	}

	/*防止 @ResponseBody时出现死循环*/
	@JsonIgnore 
	public List<User> getAUsers() {
		return AUsers;
	}

	public void setAUsers(List<User> aUsers) {
		AUsers = aUsers;
	}

	public int getNRoleId() {
		return NRoleId;
	}

	public void setNRoleId(int nRoleId) {
		NRoleId = nRoleId;
	}

	public String getSRoleName() {
		return SRoleName;
	}

	public void setSRoleName(String sRoleName) {
		SRoleName = sRoleName;
	}


	@JsonIgnore 
	public Role getOParent() {
		return OParent;
	}

	public void setOParent(Role oParent) {
		OParent = oParent;
	}

	public List<Role> getChildren() {
		return children;
	}

	public void setChildren(List<Role> children) {
		this.children = children;
	}
	
	
	
	

}
