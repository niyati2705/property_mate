package com.cts.controller;

import java.util.List;
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

import com.cts.dto.TenantDTO;
import com.cts.exception.ResourceNotFoundException;
import com.cts.model.Tenant;
import com.cts.service.TenantService;

	@RestController
	@RequestMapping("/api/tenant")
	@CrossOrigin(origins ="http://localhost:4200")
	
	public class TenantController {
	    @Autowired
	    private TenantService tenantService;
	    
	    //get all tennats
	    @GetMapping
	    public List<Tenant> getAllTenants() {
	        return tenantService.getTenants(); 
	    }

	    //get tenant by id; tenant to tennatDTO
		 @GetMapping("/{id}")
		    public TenantDTO getTenantById(@PathVariable int id) throws ResourceNotFoundException {
		        Tenant tenant= tenantService.getTenantById(id).get();;
		        return com.cts.MapperConfig.getModelMapper().map(tenant, TenantDTO.class);
		  }
		@PostMapping
	    public Tenant createTenant(@Valid @RequestBody Tenant newTenant) {
	        return tenantService.createTenant(newTenant);
	    }

//		@PutMapping("/tenant/{id}")
//	    public ResponseEntity<Tenant> updateTenant(@PathVariable(value = "id")  Integer tenantId, @Valid @RequestBody Tenant newTenant) 
//	    {
//	        return tenantService.updateTenant(tenantId, newTenant);
//	    }
//		 @PutMapping("/tenant/{id}")
//		 public ResponseEntity<Tenant> updateTenant(@PathVariable(value = "id") Integer tenantId, @Valid @RequestBody Tenant newTenant) throws ResourceNotFoundException {
//			 Tenant tenant = tenantService.getTenantById(tenantId)
//		                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found for this id :: " + tenantId));
//		        return ResponseEntity.ok().body(newTenant);
//		}

//	    @DeleteMapping("/tenant/{id}")
//		public void delete(@PathVariable(value="id") Integer tenantId){
//			
//			tenantService.deleteTenant(tenantId);
//		}
		 @DeleteMapping("/{id}")
		    public ResponseEntity<Void> deleteTenant(@PathVariable(value="id") Integer tenantId) throws ResourceNotFoundException {
		        tenantService.deleteTenant(tenantId);
		        return ResponseEntity.noContent().build();
		    }
}

	