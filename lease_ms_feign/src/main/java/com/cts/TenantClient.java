package com.cts;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.dto.TenantDTO;


@FeignClient(name = "tenant-ms", url = "http://localhost:4554")
public interface TenantClient {
    
    @GetMapping("/tenant/{id}")
    TenantDTO isValidTenant(@PathVariable("id") int id);
}
