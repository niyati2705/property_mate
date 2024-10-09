package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Tenant;
import com.cts.repository.TenantRepository;
import com.cts.service.TenantService;

@SpringBootTest
class TenantMsApplicationTests {

	 @Mock
	    private TenantRepository tenantRepository;

	    @Mock
	    private LeaseClient leaseClient;

	    @InjectMocks
	    private TenantService tenantService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    void testGetTenants() {
	        // Arrange
	        Tenant tenant1 = new Tenant();
	        tenant1.setTname("John Doe");
	        tenant1.setEmail("john@example.com");
	        
	        Tenant tenant2 = new Tenant();
	        tenant2.setTname("Jane Doe");
	        tenant2.setEmail("jane@example.com");

	        when(tenantRepository.findAll()).thenReturn(Arrays.asList(tenant1, tenant2));

	        // Act
	        List<Tenant> tenants = tenantService.getTenants();

	        // Assert
	        assertEquals(2, tenants.size());
	        //verify
	        verify(tenantRepository, times(1)).findAll();
	    }
	    
	    @Test
	    void testCreateTenant() {
	        // Arrange
	        Tenant tenant = new Tenant();
	        tenant.setTname("John Doe");
	        tenant.setEmail("john@example.com");

	        when(tenantRepository.save(tenant)).thenReturn(tenant);

	        // Act
	        Tenant createdTenant = tenantService.createTenant(tenant);

	        // Assert
	        assertNotNull(createdTenant);
	        assertEquals("John Doe", createdTenant.getTname());
	        verify(tenantRepository, times(1)).save(tenant);
	    }
	
}
