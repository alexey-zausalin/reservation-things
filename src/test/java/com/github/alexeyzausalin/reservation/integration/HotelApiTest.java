package com.github.alexeyzausalin.reservation.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HotelApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenExistedHotelId_whenGetHotel_shouldReturnHotel() throws Exception {
        this.mockMvc
                .perform(get("/api/v1/hotels/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1));
    }

    @Test
    public void givenNotExistedHotelId_whenGetHotel_shouldNoteReturnHotel() throws Exception {
        this.mockMvc
                .perform(get("/api/v1/hotels/0"))
                .andExpect(status().isNotFound());
    }
}