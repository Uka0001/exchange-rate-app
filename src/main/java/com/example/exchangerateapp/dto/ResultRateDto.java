package com.example.exchangerateapp.dto;

public record ResultRateDto (
        int currencyCode,
        double buy,
        double sale
) {
}
