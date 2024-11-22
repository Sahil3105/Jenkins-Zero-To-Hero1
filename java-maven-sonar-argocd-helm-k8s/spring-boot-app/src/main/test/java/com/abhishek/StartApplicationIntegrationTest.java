package com.abhishek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
public class StartApplicationIntegrationTest {

    @Autowired
    private StartApplication startApplication;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(startApplication).build();
    }

    @Test
    public void testIndexView() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(view().name("index"))
                .andExpect(model().attribute("title", "I have successfully built a spring boot application using Maven"))
                .andExpect(model().attribute("msg", "This application is deployed on to Kubernetes using Argo CD"));
    }
}
