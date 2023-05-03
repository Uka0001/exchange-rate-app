package com.example.exchangerateapp.mapper;

import com.example.exchangerateapp.dto.MinfinRateDto;
import com.example.exchangerateapp.model.MinfinRate;
import org.springframework.stereotype.Component;

@Component
public class MinfinRateMapper {
    public MinfinRateDto toDto(MinfinRate model) {
        return new MinfinRateDto(
                model.getId(),
                model.getPointDate(),
                model.getDate(),
                model.getAsk(),
                model.getBid(),
                model.getDesk(),
                model.getTrendAsk(),
                model.getTrendBid(),
                model.getCurrency(),
                model.getComment()
        );
    }

    public MinfinRate toModel(MinfinRateDto dto) {
        MinfinRate minfinRate = new MinfinRate();
        minfinRate.setId(dto.id());
        minfinRate.setDate(dto.date());
        minfinRate.setAsk(dto.ask());
        minfinRate.setBid(dto.bid());
        minfinRate.setDesk(dto.desk());
        minfinRate.setComment(dto.comment());
        minfinRate.setCurrency(dto.currency());
        minfinRate.setPointDate(dto.pointDate());
        minfinRate.setTrendAsk(dto.trendAsk());
        minfinRate.setTrendBid(dto.trendBid());
        return minfinRate;
    }
}
