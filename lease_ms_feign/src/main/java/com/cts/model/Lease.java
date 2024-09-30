package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Lease0")
public class Lease {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer lid;

	    @Column(name = "tenantId", nullable = false)
	    private Integer tenantId; 
	    
	    @Column(name = "startDate", nullable = false)
	    private String startDate;

	    @Column(name = "endDate", nullable = false)
	    private String endDate;

	    @Column(name = "rent", nullable = false)
	    private double rent;

	    @Column(name = "security", nullable = false)
	    private double security;

	    
//	    @ManyToOne
//	    @JoinColumn(name = "property_id", referencedColumnName= "pid")
//	    @Column(name = "propertyId", nullable = false)
//	    private Integer propertyId;

	    
	public Lease(Integer lid, String startDate, String endDate,
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
	public Lease() {
		// TODO Auto-generated constructor stub
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}

	@Column(name = "startDate", nullable = false)
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@Column(name = "endDate", nullable = false)
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Column(name = "rent", nullable = false)
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	@Column(name = "security", nullable = false)
	public double getSecurity() {
		return security;
	}
	public void setSecurity(double security) {
		this.security = security;
	}

//	  public Integer getPropertyId() {
//	        return propertyId;
//	    }
//
//	    public void setPropertyId(Integer propertyId) {
//	        this.propertyId = propertyId;
//	    }

	    public Integer getTenantId() {
	        return tenantId;
	    }

	    public void setTenantId(Integer tenantId) {
	        this.tenantId = tenantId;
	    }
    
}