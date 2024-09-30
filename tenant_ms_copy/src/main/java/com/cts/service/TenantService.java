package com.cts.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.LeaseClient;
import com.cts.dto.LeaseDTO;
import com.cts.dto.TenantDTO;
import com.cts.dto.TenantLeaseDTO;
import com.cts.model.Tenant;
import com.cts.repository.TenantRepository;

	
@Service
public class TenantService {	
	    @Autowired
	    private TenantRepository tenantRepository;
	    
	    @Autowired
	    private LeaseClient leaseClient;

	    //get all tenants
	    public List<Tenant> getTenants() {
			return (tenantRepository.findAll());
		}
	    //create tenant
	    public Tenant createTenant(@Valid Tenant tenant) {
	        return tenantRepository.save(tenant);
	    }

	    //get tenant by id
	    public Optional<Tenant> getTenantById(Integer id) {
	        return tenantRepository.findById(id);
	    }

	    //update tenant
		public ResponseEntity<Tenant> updateTenant(Integer tenantId, @Valid Tenant newTenant) {
			
			Optional<Tenant> updatedTenant = tenantRepository.findById(tenantId);
			 Tenant t1 = updatedTenant.get();
			 
			t1.setTname(newTenant.getTname());
			t1.setEmail(newTenant.getEmail());
			t1.setTaddress(newTenant.getTaddress());
			t1.setPhone(newTenant.getPhone());
				tenantRepository.save(t1);
			 System.out.println(t1);
			return ResponseEntity.ok(t1);	 
		}
		
		//delete tenant
	    public void deleteTenant(Integer id) {
	        tenantRepository.deleteById(id);
	    }
	    
	    //feign- find all leases by a tenant
	    public TenantLeaseDTO findAllLeasesByTenant(int tenantId) {
	    	List<LeaseDTO> leaselist= leaseClient.getLeaseByTenantId(tenantId);
	    	TenantLeaseDTO tenantLeaseDTO = new TenantLeaseDTO();
	    	tenantLeaseDTO.setLid(tenantId);
//	    	tenantLeaseDTO.setSecurity(tenantRepository.findById(tenantId).getSecurity());
	    	tenantLeaseDTO.setLeases(leaselist);
	    	return tenantLeaseDTO;
	    }
	

}
