package com.gsg.calculator.service.impl;

import com.gsg.calculator.enums.TaxRateProvider;
import com.gsg.calculator.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.util.Objects.isNull;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal getNetPrice(BigDecimal grossPrice, String countryCode) {
        TaxRateProvider country = TaxRateProvider.valueOf(countryCode);
        if (isNull(country.getTaxRate())) {
            return null;
        }

        // Set scale to 3 because some countries have tax rates like 11.5%
        BigDecimal taxRate = BigDecimal.valueOf(country.getTaxRate()).divide(BigDecimal.valueOf(100), 3, RoundingMode.HALF_UP);
        BigDecimal tax = grossPrice.multiply(taxRate);
        return grossPrice.subtract(tax).setScale(2, RoundingMode.HALF_UP);
    }
}
