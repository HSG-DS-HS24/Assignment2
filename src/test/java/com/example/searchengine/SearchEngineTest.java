package com.example.searchengine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SearchEngineTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void searchAPI() throws Exception {
        System.out.println("test search API");
        this.mockMvc.perform(get("/search?q=java")).andDo(print()).andExpect(status().isOk()).andExpect(header().string("Content-Type", "application/json"))
                .andExpect(content().string(containsString("https://api.interactions.ics.unisg.ch/hypermedia-environment/2e52a90a9fc94001")));
    }

    @Test
    public void luckyAPI() throws Exception {
        System.out.println("test lucky API");
        this.mockMvc.perform(get("/lucky?q=loops")).andDo(print()).andExpect(status().isFound()).andExpect(header().string("Location", containsString("https://api.interactions.ics.unisg.ch/hypermedia-environment/4c2deb2545631bac")));
    }






}
