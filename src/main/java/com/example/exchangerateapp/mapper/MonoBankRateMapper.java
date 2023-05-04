package com.example.exchangerateapp.mapper;

import com.example.exchangerateapp.dto.MonoBankRateDto;
import com.example.exchangerateapp.model.MonoBankRate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class MonoBankRateMapper {
    public MonoBankRateDto toDto(MonoBankRate model) {
        return new MonoBankRateDto(
                model.getId(),
                model.getCurrencyCodeA(),
                model.getCurrencyCodeB(),
                model.getDate(),
                model.getRateSell(),
                model.getRateBuy(),
                model.getRateCross()
        );
    }

    public MonoBankRate toModel(MonoBankRateDto dto) {
        MonoBankRate monoBankRate = new MonoBankRate();
        monoBankRate.setRateBuy(dto.rateBuy());
        monoBankRate.setRateCross(dto.rateCross());
        monoBankRate.setRateSell(dto.rateSell());
        monoBankRate.setDate(dto.date());
        monoBankRate.setCurrencyCodeA(dto.currencyCodeA());
        monoBankRate.setCurrencyCodeB(dto.currencyCodeB());
        monoBankRate.setId(dto.id());
        return monoBankRate;
    }
}
