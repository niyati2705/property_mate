package com.test;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.model.Property;
import com.cts.repository.PropertyRepository;
import com.cts.service.PropertyService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc 
//@ActiveProfiles("test")
public class AwsEmployeeApplicationTests{
	 private static final ObjectMapper om = new ObjectMapper();
	    @Autowired
	    private MockMvc mockMvc;
	@MockBean
	private PropertyService mockService;
    //@InjectMocks - Injecting the dependency in current layer/

    @BeforeEach
    public void init() {
        Property property = new Property(1, "Mumbai", "Residential");
//        when(mockService.getPropertyById(1)).thenReturn(Optional.of(property));
        when(mockService.getPropertyById(anyInt())).thenReturn(Optional.of(property));
        
//        mockMvc.perform(get)

    }

    @Test
    public void find_propertyId_OK() throws Exception {
        mockMvc.perform(get("/api/property/{1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.paddress", is("Mumbai")))
                .andExpect(jsonPath("$.ptype", is("Residential")));

        verify(mockService, times(1)).getPropertyById(1);
    }

    @Test
    public void find_propertyIdNotFound_404() throws Exception {
        when(mockService.getPropertyById(221)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/property/22")
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        verify(mockService, times(1)).getPropertyById(22);
    }

    @Test
    public void save_property_OK() throws Exception {
        Property newProperty = new Property(2, "Delhi", "Residential");
        when(mockService.createProperty(any(Property.class))).thenReturn(newProperty);

        mockMvc.perform(post("/property")
                .content(om.writeValueAsString(newProperty))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.pid", is(2)))
                .andExpect(jsonPath("$.paddress", is("Delhi")))
                .andExpect(jsonPath("$.ptype", is("Residential")));

        verify(mockService, times(1)).createProperty(any(Property.class));
    }
}