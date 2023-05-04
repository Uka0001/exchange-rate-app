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
/*
[
            {
            "ccy":"EUR",
            "base_ccy":"UAH",
            "buy":"19.20000",
            "sale":"20.00000"
            },
            {
            "ccy":"USD",
            "base_ccy":"UAH",
            "buy":"15.50000",
            "sale":"15.85000"
            }
            ]
* */
