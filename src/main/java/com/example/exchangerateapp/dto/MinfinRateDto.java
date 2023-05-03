package com.example.exchangerateapp.dto;

public record MinfinRateDto(
        Long id,
        String pointDate,
        String date,
        float ask,
        float bid,
        float desk,
        float trendAsk,
        float trendBid,
        String currency,
        String comment
) {

}
