package com.example.exchangerateapp.dto;

public record MonoBankRateDto(
        Long id,
        int currencyCodeA,
        int currencyCodeB,
        long date,
        float rateSell,
        float rateBuy,
        float rateCross
) {
}
