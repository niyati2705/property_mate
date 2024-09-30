package com.cts.controller;

import com.cts.dto.LeaseDTO;
import com.cts.model.Lease;
import com.cts.service.LeaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/lease")
@CrossOrigin(origins ="http://localhost:4200")
public class LeaseController {

    @Autowired
    private LeaseService leaseService;

    // Create a new lease
    @PostMapping
    public Lease createLease(@Valid @RequestBody LeaseDTO newLeaseDTO) {
//    	System.out.println("Lease received: "+newLease);
        return leaseService.createLease(newLeaseDTO);
    }

    // Get all leases
    @GetMapping
    List<Lease> leases() {
        return leaseService.getAllLease(); 
    }
    
//    // Get Lease by ID
//    @GetMapping("/{id}")
//    Optional<Lease> getLeaseById(@PathVariable int id)
//    {
//		return leaseService.getLeaseById(id);
//	}
    
    @GetMapping("/{tenantId}/leases")
    public List<LeaseDTO> getOrders(@PathVariable int tenantId) {

        return leaseService.getLeaseForTenantById(tenantId);
    }


    // Update a lease
    @PutMapping("/{id}")
    public Lease updateLease(@PathVariable Integer id, @RequestBody Lease updatedLease) {
          return  leaseService.updateLease(id, updatedLease);
       
    }

    // Delete a lease
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLease(@PathVariable Integer id) {
        leaseService.deleteLease(id);
        return ResponseEntity.ok("Lease deleted successfully.");
    }
    
}
