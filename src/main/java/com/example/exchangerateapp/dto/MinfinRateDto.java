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
/*
[
{
"id": 0,
"pointDate": "2023-05-02T13:14:27Z",
"date": "2023-05-02T13:14:27Z",
"ask": "string",
"desk": "string",
"trendAsk": "string",
"trendBid": "string",
"currency": "string",
"comment": "string"
}
]
* */
