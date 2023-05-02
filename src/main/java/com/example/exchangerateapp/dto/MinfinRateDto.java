package com.example.exchangerateapp.dto;

import java.time.LocalDateTime;

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
