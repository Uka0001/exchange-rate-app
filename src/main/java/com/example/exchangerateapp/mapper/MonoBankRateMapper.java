package com.example.exchangerateapp.mapper;

import com.example.exchangerateapp.dto.MonoBankRateDto;
import com.example.exchangerateapp.model.MonoBankRate;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.TimeZone;

@Component
public class MonoBankRateMapper {
    public MonoBankRateDto toDto(MonoBankRate monoBankRate) {
        return new MonoBankRateDto(
                monoBankRate.getId(),
                monoBankRate.getCurrencyCodeA(),
                monoBankRate.getCurrencyCodeB(),
                monoBankRate.getDate(),
                monoBankRate.getRateSell(),
                monoBankRate.getRateBuy(),
                monoBankRate.getRateCross()
        );
    }

    public MonoBankRate toModel(MonoBankRateDto rateDto) {
        MonoBankRate monoBankRate = new MonoBankRate();
        monoBankRate.setRateBuy(rateDto.rateBuy());
        monoBankRate.setRateCross(rateDto.rateCross());
        monoBankRate.setRateSell(rateDto.rateSell());
        monoBankRate.setDate(rateDto.date());
        monoBankRate.setCurrencyCodeA(rateDto.currencyCodeA());
        monoBankRate.setCurrencyCodeB(rateDto.currencyCodeB());
        monoBankRate.setId(rateDto.id());
        return monoBankRate;
    }
}
