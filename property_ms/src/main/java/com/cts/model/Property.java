package com.cts.model;

import java.rmi.dgc.Lease;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Property1")
public class Property {
	
	int pid;
	
	//validators
	@NotBlank(message = "City name for property is required")
	String paddress;
	
	@NotBlank(message = "Property type is required")
	String ptype;
	
	@OneToMany(mappedBy="property")
	private List<Lease> leases;
	
	public Property(int pid, String paddress, String ptype) {
		super();
		this.pid = pid;
		this.paddress = paddress;
		this.ptype = ptype;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	} 

	//getter and setters
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(name = "paddress", nullable = false)
	public String getPaddress() {
		return paddress;
	}


	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	@Column(name = "ptype", nullable = false)
	public String getPtype() {
		return ptype;
	}


	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	
}
