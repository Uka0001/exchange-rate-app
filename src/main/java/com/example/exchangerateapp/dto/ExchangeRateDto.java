package com.example.exchangerateapp.dto;

import java.time.LocalDate;

public record ExchangeRateDto(
        Long id,
        LocalDate date,
        float buy,
        float sale,
        int currencyCode
) {
}
