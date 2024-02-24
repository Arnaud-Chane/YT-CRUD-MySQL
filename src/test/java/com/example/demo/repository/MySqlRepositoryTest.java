package com.example.demo.repository;

import com.example.demo.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        Address address = new Address(); // create an Address object with the expected properties
        when(mySqlRepository.findById(1)).thenReturn(Optional.of(address));

        mockMvc.perform(get("/get-address/{identity}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.property", is("expectedValue"))); // replace "property" and "expectedValue" with the actual property name and expected value of the Address object
    }
}
