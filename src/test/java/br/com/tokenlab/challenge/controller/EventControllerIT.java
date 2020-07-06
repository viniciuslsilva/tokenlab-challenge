package br.com.tokenlab.challenge.controller;

import br.com.tokenlab.challenge.dto.EventDTO;
import br.com.tokenlab.challenge.repository.EventRepository;
import br.com.tokenlab.challenge.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EventControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    EventRepository eventRepository;

    @Test
    void saveNewEvent() throws Exception {
        EventDTO eventDTO = EventDTO.builder()
                .description("Java Week")
                .dateStart(LocalDateTime.parse("15/04/2021 20:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .dateEnd(LocalDateTime.parse("15/04/2021 23:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .build();
        String body = JsonUtil.asJsonString(eventDTO);

        mockMvc.perform(post("/events")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", any(Integer.class)))
                .andExpect(jsonPath("$.description", equalToIgnoringCase("Java Week")))
                .andExpect(jsonPath("$.dateStart", equalTo("15/04/2021 20:00:00")))
                .andExpect(jsonPath("$.dateEnd", equalTo("15/04/2021 23:00:00")))
                .andExpect(status().isOk());
    }

    @Test
    void listEvent() throws Exception {
        EventDTO eventDTO = EventDTO.builder()
                .description("Java Week")
                .dateStart(LocalDateTime.parse("15/04/2021 20:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .dateEnd(LocalDateTime.parse("15/04/2021 23:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .build();
        eventRepository.save(eventDTO.newEvent());

        mockMvc.perform(get("/events"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", any(Integer.class)))
                .andExpect(jsonPath("$[0].description", equalToIgnoringCase("Java Week")))
                .andExpect(jsonPath("$[0].dateStart", equalTo("15/04/2021 20:00:00")))
                .andExpect(jsonPath("$[0].dateEnd", equalTo("15/04/2021 23:00:00")))
                .andExpect(status().isOk());
    }
}