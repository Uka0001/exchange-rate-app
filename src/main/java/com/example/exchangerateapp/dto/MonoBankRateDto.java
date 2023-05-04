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
/*
[
{
"currencyCodeA": 840,
"currencyCodeB": 980,
"date": 1552392228,
"rateSell": 27,
"rateBuy": 27.2,
"rateCross": 27.1
}
]
* */
