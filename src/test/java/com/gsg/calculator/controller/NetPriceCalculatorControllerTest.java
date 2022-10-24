package com.gsg.calculator.controller;

import com.gsg.calculator.service.CalculatorService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class NetPriceCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void invalidCountryCodeTest() throws Exception {
        when(calculatorService.getNetPrice(any(BigDecimal.class), anyString())).thenThrow(new IllegalArgumentException());

        mockMvc.perform(get("/net-price?grossPrice=100&countryCode=ABX"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void nullCountryCodeTest() throws Exception {
        when(calculatorService.getNetPrice(any(BigDecimal.class), anyString())).thenThrow(new NullPointerException());

        mockMvc.perform(get("/net-price?grossPrice=100&countryCode=null"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void countryWithUnknownTaxRate() throws Exception {
        when(calculatorService.getNetPrice(any(BigDecimal.class), anyString())).thenReturn(null);

        mockMvc.perform(get("/net-price?grossPrice=100&countryCode=VU"))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void successfulTest() throws Exception {
        when(calculatorService.getNetPrice(any(BigDecimal.class), anyString())).thenReturn(BigDecimal.valueOf(81.0));

        mockMvc.perform(get("/net-price?grossPrice=100&countryCode=DE"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is(81.0)));
    }

}
