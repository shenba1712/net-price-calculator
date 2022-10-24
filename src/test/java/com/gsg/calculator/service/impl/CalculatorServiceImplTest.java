package com.gsg.calculator.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CalculatorServiceImplTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @Test
    public void invalidCountryCode() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                calculatorService.getNetPrice(BigDecimal.TEN, "ABC"));
    }

    @Test
    public void nullCountryCode() {
        Assertions.assertThrows(NullPointerException.class, () ->
                calculatorService.getNetPrice(BigDecimal.TEN, null));
    }

    @Test
    public void unknownTaxRate() {
        BigDecimal netPrice = calculatorService.getNetPrice(BigDecimal.TEN, "VU");
        Assertions.assertNull(netPrice);
    }

    @Test
    public void successTaxRateForThreeDecimalPlaces() {
        BigDecimal netPrice = calculatorService.getNetPrice(BigDecimal.TEN, "US"); // Tax rate of US is 11.5%
        Assertions.assertEquals(BigDecimal.valueOf(8.85), netPrice);
    }

    @Test
    public void successTaxRate() {
        BigDecimal netPrice = calculatorService.getNetPrice(BigDecimal.TEN, "DE");
        Assertions.assertEquals(BigDecimal.valueOf(8.1), netPrice);
    }
}
