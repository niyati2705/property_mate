package com.test;

import com.cts.model.Property;
import com.cts.repository.PropertyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// RunAs -> Maven build-> Clean Test
//@WebMvcTest(BookController.class)
@RunWith(SpringRunner.class)
@SpringBootTest
/* Configure our runtime environment;
 * The @SpringBootTest annotation is useful when we need to bootstrap the entire container.
The annotation works by creating the ApplicationContext that will be utilized in our tests.*/
@AutoConfigureMockMvc //To use Spring Mock MVC Test Framework, we need to use @AutoConfigureMockMvc.
@ActiveProfiles("test") //is a class-level annotation that is used to activate profiles while loading ApplicationContext in Spring integration test
public class PropertyControllerTest{
 
    private static final ObjectMapper om = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    // @MockBean to provide mock implementations for required collaborators in the controller class.
 
    private PropertyRepository mockRepository;
    //@InjectMocks - Injecting the dependency in current layer/

    @Before
    public void init() {
        Property property = new Property(1, "Mumbai", "Residential");
        when(mockRepository.findById(1)).thenReturn(Optional.of(property));
    }

    @Test
    public void find_propertyId_OK() throws Exception {

        mockMvc.perform(get("/property/1"))
                /*.andDo(print())*/
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pid", is(1)))
                .andExpect(jsonPath("$.paddress", is("Mumbai")))
                .andExpect(jsonPath("$.ptype", is("Residential")));

        verify(mockRepository, times(1)).findById(1);
    }

    @Test
    public void update_property_OK() throws Exception {

        Property updateProperty= new Property(1, "MumbaiNew", "Residential");
        when(mockRepository.save(any(Property.class))).thenReturn(updateProperty);

        mockMvc.perform(put("/property/1")
                .content(om.writeValueAsString(updateProperty))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pid", is(1)))
                .andExpect(jsonPath("$.paddress", is("MumbaiNew")))
                .andExpect(jsonPath("$.ptype", is("Residential")));
    }



@Test
public void delete_property_OK() throws Exception {

    doNothing().when(mockRepository).deleteById(1);

    mockMvc.perform(delete("/property/1"))
            /*.andDo(print())*/
            .andExpect(status().isOk());

    verify(mockRepository, times(1)).deleteById(1);
}

private static void printJSON(Object object) {
    String result;
    try {
        result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        System.out.println(result);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
}

}