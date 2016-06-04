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
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="TS_POWER")
public class Power implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6773016074297392716L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "N_POWER_ID")
	private int NPowerId;
	
	@Column(name = "N_POWER_NAME")
	private String SPowerName;
	
	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "APowers", fetch = FetchType.LAZY)
    protected List<Tree> ATrees=new ArrayList<Tree>();
	
	@JsonIgnore 
	public List<Tree> getATrees() {
		return ATrees;
	}

	public void setATrees(List<Tree> aTrees) {
		ATrees = aTrees;
	}

	public int getNPowerId() {
		return NPowerId;
	}

	public void setNPowerId(int nPowerId) {
		NPowerId = nPowerId;
	}

	public String getSPowerName() {
		return SPowerName;
	}

	public void setSPowerName(String sPowerName) {
		SPowerName = sPowerName;
	}

	
}
