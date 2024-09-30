package com.cts.service;

import com.cts.PropertyClient;
import com.cts.TenantClient;
import com.cts.dto.LeaseDTO;
import com.cts.model.Lease;
import com.cts.repository.LeaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.*;
import javax.validation.Valid;

@Service
public class  LeaseService {

	private static final Logger logger = LoggerFactory.getLogger(LeaseService.class);
    @Autowired
    private LeaseRepository leaseRepository;

//    @Autowired
//    private PropertyClient propertyClient;

    @Autowired
    private TenantClient tenantClient;
    
    public List<LeaseDTO> getLeaseForTenantById(int tenantId) {

		List<Lease> leases= leaseRepository.findByTenantId(tenantId);
		 
        if (leases.isEmpty()) {
            logger.warn("No leases found for tenant ID: {}", tenantId);
        } else {
            logger.info("Found {} leases for tenant ID: {}", leases.size(), tenantId);
        }

		List<LeaseDTO> leaseDTOS = new ArrayList<>();
		for(Lease lease:leases) {
			LeaseDTO leaseDTO = convertToDTO(lease);
			leaseDTOS.add(leaseDTO);
		}
		return leaseDTOS;
	 }
    
    public LeaseDTO convertToDTO(Lease lease) {
	    if (lease == null) {
	        return null;
	    }

	    LeaseDTO leaseDTO = new LeaseDTO();
	    leaseDTO.setLid(lease.getLid());
	    leaseDTO.setStartDate(lease.getStartDate());
	    leaseDTO.setEndDate(lease.getEndDate());
	    leaseDTO.setRent(lease.getRent());
	    leaseDTO.setSecurity(lease.getSecurity());
	    
	    return leaseDTO;
    }
   //get lease by id
    public Optional<Lease> getLeaseById(Integer id) {
        return leaseRepository.findById(id);
    }

    // get all
    public List<Lease> getAllLease() {
        return leaseRepository.findAll();
    }
    
	 public Lease createLease(LeaseDTO leaseDTO) {
	        // Create a new Lease entity and set fields manually from the DTO
	        Lease lease = new Lease();
//	        lease.setPropertyId(leaseDTO.getPropertyId());
	        lease.setTenantId(leaseDTO.getTenantId());
	        lease.setStartDate(leaseDTO.getStartDate());
	        lease.setEndDate(leaseDTO.getEndDate());
	        lease.setRent(leaseDTO.getRent());
	        lease.setSecurity(leaseDTO.getSecurity());
	        

	        // Save the Lease entity in the database
	        return leaseRepository.save(lease);
	    }


 // Update lease
    public Lease updateLease(Integer leaseId, @Valid Lease newLease) {
        Optional<Lease> lease = leaseRepository.findById(leaseId);
        
        if (lease.isPresent()) {
        	 Lease updatedLease = lease.get();
             updatedLease.setStartDate(newLease.getStartDate());
             updatedLease.setEndDate(newLease.getEndDate());
             updatedLease.setRent(newLease.getRent());
             updatedLease.setSecurity(newLease.getSecurity());
             return leaseRepository.save(updatedLease);
         }
         throw new RuntimeException("Lease not found");
        
    }
    
    //delete lease
    public void deleteLease(Integer id) {
        leaseRepository.deleteById(id);
    }
   
    
}
