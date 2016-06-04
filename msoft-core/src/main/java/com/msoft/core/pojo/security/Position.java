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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="TS_POSITION")
public class Position implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8071483783836816919L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "N_POSITION_ID")
	private int NPositionId;
	
	@Column(name = "N_POSITION_NAME")
	private String SPositionName;
	
	@ManyToOne
	private Position OParent;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "OParent")
	@OrderBy("N_POSITION_ID DESC")
	private List<Position> children = new ArrayList<Position>();
	
	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "APositions", fetch = FetchType.LAZY)
    protected List<User> AUsers=new ArrayList<User>();
	
	
	@JsonIgnore
	public Position getOParent() {
		return OParent;
	}

	public void setOParent(Position oParent) {
		OParent = oParent;
	}

	public List<Position> getChildren() {
		return children;
	}

	public void setChildren(List<Position> children) {
		this.children = children;
	}

	@JsonIgnore 
	public List<User> getAUsers() {
		return AUsers;
	}

	public void setAUsers(List<User> aUsers) {
		AUsers = aUsers;
	}

	public int getNPositionId() {
		return NPositionId;
	}

	public void setNPositionId(int nPositionId) {
		NPositionId = nPositionId;
	}

	public String getSPositionName() {
		return SPositionName;
	}

	public void setSPositionName(String sPositionName) {
		SPositionName = sPositionName;
	}
	
	

}
