package com.cts.dto;

public class PropertyDTO {
    private Integer propertyId;
    private String address;
    private String type;


    public PropertyDTO() {
        // Default constructor
    }

    public PropertyDTO(Integer propertyId, String address, String type) {
        this.propertyId = propertyId;
        this.address = address;
        this.type = type;
     
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   

}
