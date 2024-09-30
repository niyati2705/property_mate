package com.cts;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.dto.LeaseDTO;

@FeignClient(name="lease-ms-feign", url = "http://localhost:4334")

public interface LeaseClient {
	  @GetMapping("/lease/{id}/leases")
		List<LeaseDTO> getLeaseByTenantId(@PathVariable("id") int tenantId);

}
