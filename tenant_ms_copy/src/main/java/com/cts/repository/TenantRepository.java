package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Tenant;
@Repository
public interface TenantRepository extends JpaRepository<Tenant,Integer> {
}

