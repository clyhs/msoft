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
import javax.persistence.Table;

@Entity
@Table(name="TS_USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488344195160824633L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "N_USER_ID")
	private int NUserId;
	
	@Column(name = "N_USER_NAME")
	private String SUserName;
	
	/**/
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "TS_USER_GROUP", joinColumns = {
	@JoinColumn(name = "N_USER_ID")}, inverseJoinColumns = {
	@JoinColumn(name = "N_GROUP_ID")})
	private List<Group> AGroups = new ArrayList<Group>();
	
	/**/
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "TS_USER_ROLE", joinColumns = {
	@JoinColumn(name = "N_USER_ID")}, inverseJoinColumns = {
	@JoinColumn(name = "N_ROLE_ID")})
	private List<Role> ARoles = new ArrayList<Role>();
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "TS_USER_POSITION", joinColumns = {
    @JoinColumn(name = "N_USER_ID")}, inverseJoinColumns = {
    @JoinColumn(name = "N_POSITION_ID")})
    protected List<Position> APositions = new ArrayList<Position>();
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "TS_USER_TREE", joinColumns = {
    @JoinColumn(name = "N_USER_ID")}, inverseJoinColumns = {
    @JoinColumn(name = "N_TREE_ID")})
    protected List<Tree> ATrees = new ArrayList<Tree>();
	
	
	
	
	public List<Tree> getATrees() {
		return ATrees;
	}
	public void setATrees(List<Tree> aTrees) {
		ATrees = aTrees;
	}
	public List<Position> getAPositions() {
		return APositions;
	}
	public void setAPositions(List<Position> aPositions) {
		APositions = aPositions;
	}
	public List<Role> getARoles() {
		return ARoles;
	}
	public void setARoles(List<Role> aRoles) {
		ARoles = aRoles;
	}
	public int getNUserId() {
		return NUserId;
	}
	public void setNUserId(int nUserId) {
		NUserId = nUserId;
	}
	public String getSUserName() {
		return SUserName;
	}
	public void setSUserName(String sUserName) {
		SUserName = sUserName;
	}
	public List<Group> getAGroups() {
		return AGroups;
	}
	public void setAGroups(List<Group> aGroups) {
		AGroups = aGroups;
	}

	
}
