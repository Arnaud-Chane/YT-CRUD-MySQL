package com.example.demo.repository;

import com.example.demo.model.Address;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-test.properties")
public class MySqlRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MySqlRepository mySqlRepository;

    @Test
    public void testGetAllAddresses() throws Exception {
        mockMvc.perform(get("/get-all-addresses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5))); // replace 3 with the expected number of addresses
    }

    @Test
    public void testGetSingleAddress() throws Exception {
        Address address = new Address(123, "Baker Street", "NW1 6XE"); // create an Address object with the expected properties
        when(mySqlRepository.findById(1)).thenReturn(Optional.of(address));

        mockMvc.perform(get("/get-address/{identity}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.street", is("Baker Street")))
                .andExpect(jsonPath("$.number", is(123)))
                .andExpect(jsonPath("$.postcode", is("NW1 6XE")));

        verify(mySqlRepository, times(1)).findById(1);
    }

    @Test
    public void testDeleteRow() throws Exception {
        when(mySqlRepository.findById(1)).thenReturn(Optional.of(new Address()));

        mockMvc.perform(delete("/remove/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        verify(mySqlRepository, times(1)).deleteById(1);
    }

    @Test
    public void testUpdateAddress() throws Exception {
        when(mySqlRepository.findById(1)).thenReturn(Optional.of(new Address()));

        String requestBody = "{\"street\":\"newStreet\",\"number\":\"123\",\"postcode\":\"newPostcode\"}";

        mockMvc.perform(put("/update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.street", is("newStreet")))
            .andExpect(jsonPath("$.number", is(123)))
            .andExpect(jsonPath("$.postcode", is("newPostcode")));

        verify(mySqlRepository, times(1)).save(org.mockito.ArgumentMatchers.any(Address.class));
    }

    @Test
    public void testCreate() throws Exception {
        Address address = new Address(232, "Spring", "Boot"); // create an Address object with the expected properties
        when(mySqlRepository.save(org.mockito.ArgumentMatchers.any(Address.class))).thenReturn(address);

        String requestBody = "{\"street\":\"Spring\",\"number\":\"232\",\"postcode\":\"Boot\"}";

        mockMvc.perform(post("/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.street", is("Spring")))
                .andExpect(jsonPath("$.number", is(232)))
                .andExpect(jsonPath("$.postcode", is("Boot")));

        verify(mySqlRepository, times(1)).save(org.mockito.ArgumentMatchers.any(Address.class));
    }
}
