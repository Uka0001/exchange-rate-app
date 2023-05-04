package com.example.exchangerateapp.mapper;

import com.example.exchangerateapp.dto.MinfinRateDto;
import com.example.exchangerateapp.model.CurrencyCode;
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
                String.valueOf(model.getCurrency()),
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
        CurrencyCode currencyCode
                = CurrencyCode.valueOf(dto.currency().toUpperCase());
        String currencyCodeString
                = String.valueOf(currencyCode.getCode());
        minfinRate.setCurrency(Integer.parseInt(currencyCodeString));
        minfinRate.setPointDate(dto.pointDate());
        minfinRate.setTrendAsk(dto.trendAsk());
        minfinRate.setTrendBid(dto.trendBid());
        return minfinRate;
    }
}
