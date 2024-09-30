package com.cts.dto;

public class TenantDTO{
	
	int tid;
	String tname;
	String email;
	String taddress;
	Long phone;

	
	public TenantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TenantDTO(int tid, String tname, String email, String taddress, Long phone) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.email = email;
		this.taddress = taddress;
		this.phone = phone;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTaddress() {
		return taddress;
	}

	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

}
