package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

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

    @Test
    public void testGetAllAddresses() throws Exception {
        mockMvc.perform(get("/get-all-addresses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5))); // replace 3 with the expected number of addresses
    }
}
