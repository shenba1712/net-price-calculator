package com.gsg.calculator.controller;

import com.gsg.calculator.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

@RestController
@Slf4j
@RequestMapping("net-price")
public class NetPriceCalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public ResponseEntity<BigDecimal> getNetPrice(@RequestParam BigDecimal grossPrice, @RequestParam String countryCode) {
        try {
            BigDecimal netPrice = calculatorService.getNetPrice(grossPrice, countryCode);
            if (isNull(netPrice)) {
                log.error("Cannot find tax rate of country with code: " + countryCode);
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return ResponseEntity.ok(netPrice);
        } catch (IllegalArgumentException | NullPointerException exception) {
            log.error("Invalid country code: " + countryCode);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
