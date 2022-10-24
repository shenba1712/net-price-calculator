package com.gsg.calculator.service;

import java.math.BigDecimal;

public interface CalculatorService {

    BigDecimal getNetPrice(BigDecimal grossPrice, String countryCode);
}
