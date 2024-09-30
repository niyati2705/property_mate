package com.cts.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Tenant")
public class Tenant {
	
	int tid;
	
	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 20, message = "First name should be between 3 and 20 characters")
	String tname;
	
	@NotBlank(message = "Email is required")
	@Email(message="Email is invalid")
	String email;
	String taddress;

	Long phone;

	
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tenant(int tid, String tname, String email, String taddress, Long phone) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.email = email;
		this.taddress = taddress;
		this.phone = phone;
	}

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Column(name = "tname", nullable = false)
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}


	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name = "taddress", nullable = false)
	public String getTaddress() {
		return taddress;
	}

	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}

	@Column(name = "phone", nullable = false)
	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
}
