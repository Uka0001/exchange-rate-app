package com.example.exchangerateapp.dto;

public record PrivatBankRateDto(
        Long id,
        String ccy,
        String base_ccy,
        float buy,
        float sale,
        String date
) {
}
