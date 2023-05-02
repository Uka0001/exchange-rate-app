package com.example.exchangerateapp.dto;

import java.math.BigDecimal;

public record PrivatBankRateDto(
        Long id,
        String ccy,
        String base_ccy,
        float buy,
        float sale
) {
}
