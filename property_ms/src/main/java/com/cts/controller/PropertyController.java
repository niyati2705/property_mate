package com.cts.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ResourceNotFoundException;
import com.cts.model.Property;
import com.cts.service.PropertyService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PropertyController {
	@Autowired
	private PropertyService propertyService;

	//get all properties
	@GetMapping("/property")
	List<Property> properties() {
		return propertyService.getProperties(); 
	}

	//find property by id
	@GetMapping("/property/{id}")
	public ResponseEntity<Property> getPropertyById(@PathVariable int id) throws ResourceNotFoundException {
		Property property = propertyService.getPropertyById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Property not found for this id :: " + id));
		return ResponseEntity.ok().body(property);
	}

	//create property
	@PostMapping("/property")
	public Property createProperty(@Valid @RequestBody Property newProperty) {
		return propertyService.createProperty(newProperty);
	}

	// update property
	@PutMapping("/property/{id}")
	public ResponseEntity<Property> updateProp(@PathVariable(value = "id") Integer propertyId,
			@Valid @RequestBody Property newProperty) throws ResourceNotFoundException {
		Property property = propertyService.getPropertyById(propertyId)
				.orElseThrow(() -> new ResourceNotFoundException("Property not found for this id :: " + propertyId));
		return ResponseEntity.ok().body(property);
	}

	// delete property
	@DeleteMapping("/property/{id}")
	public ResponseEntity<Void> deleteProperty(@PathVariable(value = "id") Integer propertyId)
			throws ResourceNotFoundException {
		propertyService.deleteProperty(propertyId);
		return ResponseEntity.noContent().build();
	}
}
