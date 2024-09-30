package com.cts.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Lease;

public interface LeaseRepository extends JpaRepository<Lease,Integer> {
	 //  find all lease for a tenant id
		List<Lease> findByTenantId(int tenantId);
	}

