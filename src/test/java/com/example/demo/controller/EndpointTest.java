package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser(authorities="USER")
    @Test
    void endpointWhenUserAuthorityThenAuthorized() throws Exception {
        this.mockMvc.perform(get("/endpoint"))
                .andExpect(status().isOk());
    }

    @WithMockUser
    @Test
    void endpointWhenNotUserAuthorityThenForbidden() throws Exception {
        this.mockMvc.perform(get("/endpoint"))
                .andExpect(status().isForbidden());
    }

    @Test
    void anyWhenUnauthenticatedThenUnauthorized() throws Exception {
        this.mockMvc.perform(get("/any"))
                .andExpect(status().isUnauthorized());
    }
}
