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
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.ResponseBody;

@Entity
@Table(name="TS_GROUP")
public class Group implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5696307649674635619L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "N_GROUP_ID")
	private int NGroupId;
	
	@Column(name = "N_GROUP_NAME")
	private String SGroupName;
	
	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "AGroups", fetch = FetchType.LAZY)
    protected List<User> AUsers=new ArrayList<User>();
	
	
	/**/
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "TS_GROUP_ROLE", joinColumns = {
	@JoinColumn(name = "N_GROUP_ID")}, inverseJoinColumns = {
	@JoinColumn(name = "N_ROLE_ID")})
	private List<Role> ARoles = new ArrayList<Role>();

	public List<Role> getARoles() {
		return ARoles;
	}

	public void setARoles(List<Role> aRoles) {
		ARoles = aRoles;
	}

	/*防止 @ResponseBody时出现死循环*/
	@JsonIgnore 
	public List<User> getAUsers() {
		return AUsers;
	}

	public void setAUsers(List<User> aUsers) {
		AUsers = aUsers;
	}

	public int getNGroupId() {
		return NGroupId;
	}

	public void setNGroupId(int nGroupId) {
		NGroupId = nGroupId;
	}

	public String getSGroupName() {
		return SGroupName;
	}

	public void setSGroupName(String sGroupName) {
		SGroupName = sGroupName;
	}
	
	

}
