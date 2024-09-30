package com.cts.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.model.Property;
import com.cts.repository.PropertyRepository;
import com.wipro.model.Product;
	
@Service
public class PropertyService {
	    @Autowired
	    private PropertyRepository propertyRepository;

	    //get all properties
	    public List<Property> getProperties() {
			return (propertyRepository.findAll());
		}
	    //create property
	    public Property createProperty(@Valid Property property) {
	        return propertyRepository.save(property);
	    }

	    //find property by id
	    public Optional<Property> getPropertyById(Integer id) {
	        return propertyRepository.findById(id);
	    }

	    //get all properties
	    public List<Property> getAllProperties() {
	        return propertyRepository.findAll();
	    }

	    //update a property
		public ResponseEntity<Property> updateProperty(Integer propertyId, @Valid Property newProperty) {
			
			Optional<Property> updatedProperty = propertyRepository.findById(propertyId);
			 Property p1 = updatedProperty.get();
			 
			p1.setPaddress(newProperty.getPaddress());
				p1.setPtype(newProperty.getPtype());
				propertyRepository.save(p1);
			 System.out.println(p1);
			return ResponseEntity.ok(p1);	 
		}
		
	    public void deleteProperty(Integer id) {
	        propertyRepository.deleteById(id);
	    }
	

}
