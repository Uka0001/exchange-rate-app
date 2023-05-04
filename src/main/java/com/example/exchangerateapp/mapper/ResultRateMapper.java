package com.example.exchangerateapp.mapper;

import com.example.exchangerateapp.dto.ResultRateDto;
import org.springframework.stereotype.Component;

@Component
public class ResultRateMapper {
    public ResultRateDto rateDto(Object[] model) {
        return new ResultRateDto(
                (int) model[0],
                (double) model[1],
                (double) model[2]
        );
    }
}
