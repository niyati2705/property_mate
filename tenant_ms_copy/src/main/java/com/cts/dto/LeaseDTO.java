package com.cts.dto;

public class LeaseDTO {

	    private Integer lid;

	    private String startDate;

	    private String endDate;

	    private double rent;

	    private double security;

//	       private Integer propertyId;

	    private Integer tenantId; 
	    
	public LeaseDTO(Integer lid, String startDate, String endDate,
			double rent, double security ,Integer tenantId) {
		super();
		this.lid = lid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rent = rent;
		this.security = security;
//		this.propertyId = propertyId;
		this.tenantId = tenantId;
	}
	public LeaseDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}

	public double getSecurity() {
		return security;
	}
	public void setSecurity(double security) {
		this.security = security;
	}

  public Integer getTenantId() {
	        return tenantId;
	    }

 public void setTenantId(Integer tenantId) {
	        this.tenantId = tenantId;
	    }
    
}