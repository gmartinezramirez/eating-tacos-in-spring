package com.gmartinezramirez.eatingTacos.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

  @Autowired MockMvc mockMvc;

  @Test
  public void givenGreetingUri_whenMockMVC_thenVerifyResponse() throws Exception {
    // Given
    final var resourceUri = "/hello";
    final var expectedId = 1;
    final var expectedMessage = "Hello World!";

    // When - Then
    this.mockMvc
        .perform(get(resourceUri))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(expectedId))
        .andExpect(jsonPath("$.message").value(expectedMessage))
        .andReturn();
  }
}
