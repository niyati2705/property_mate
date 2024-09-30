package com.cts;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.dto.PropertyDTO;

@FeignClient(name = "property-ms", url = "${PROPERTY_SERVICE:http://localhost:4444}")
public interface PropertyClient {
    
    @GetMapping("/api/property/{id}")
    PropertyDTO getPropertyById(@PathVariable("id") Integer property);
}