package com.example.demo.repository;

import com.example.demo.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
public class GetAllAddressesTestMockito {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressRepository addressRepository;

    @BeforeEach
    public void setUp() {
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Address address = new Address();
            address.setId(i);
            address.setStreet("Street " + i);
            address.setNumber(i);
            address.setPostcode("Postcode " + i);
            addresses.add(address);
        }

        when(addressRepository.findAll()).thenReturn(addresses);
    }

    @Test
    public void testGetAllAddresses() throws Exception {
        mockMvc.perform(get("/get-all-addresses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(20)));
    }
}