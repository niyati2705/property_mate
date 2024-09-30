package com.cts.dto;

public class LeaseDTO {

//    private Integer propertyId;
	private int lid;
    private int tenantId;
    private String startDate;
    private String endDate;
    private Double rent;
    private Double security;


    // Getters and Setters

//    public Integer getPropertyId() {
//        return propertyId;
//    }
//
//    public void setPropertyId(Integer propertyId) {
//        this.propertyId = propertyId;
//    }

    
    public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	 public int getTenantId() {
	        return tenantId;
	    }

	public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
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

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Double getSecurity() {
        return security;
    }

    public void setSecurity(Double security) {
        this.security = security;
    }

  
}
