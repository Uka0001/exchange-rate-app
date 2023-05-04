package com.example.exchangerateapp.mapper;

import com.example.exchangerateapp.dto.ExchangeRateDto;
import com.example.exchangerateapp.dto.MinfinRateDto;
import com.example.exchangerateapp.dto.MonoBankRateDto;
import com.example.exchangerateapp.model.CurrencyCode;
import com.example.exchangerateapp.model.ExchangeRate;
import com.example.exchangerateapp.model.PrivatBankRate;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateMapper {

    public ExchangeRateDto minfinDtoToDto(MinfinRateDto dto) {
        String dateTimeString = dto.date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDate date = dateTime.toLocalDate();
        return new ExchangeRateDto(
                dto.id(),
                date,
                dto.ask(),
                dto.bid(),
                Integer.parseInt(dto.currency())
        );
    }

    public ExchangeRateDto monoDtoToDto(MonoBankRateDto dto) {
        Instant instant = Instant.ofEpochSecond(dto.date());
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.UTC);
        LocalDate localDate = offsetDateTime.toLocalDate();
        float buy = dto.rateBuy() > 0 ? dto.rateBuy() : dto.rateCross();
        float sale = dto.rateSell() > 0 ? dto.rateSell() : dto.rateCross();
        return new ExchangeRateDto(
                dto.id(),
                localDate,
                buy,
                sale,
                dto.currencyCodeA()
        );
    }

    public ExchangeRateDto privatModelToDto(PrivatBankRate model) {
        String codeCcy = model.getCcy();
        String dateTimeString = model.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDate date = dateTime.toLocalDate();
        return new ExchangeRateDto(
                model.getId(),
                date,
                model.getBuy(),
                model.getSale(),
                CurrencyCode.valueOf(codeCcy).getCode()
        );
    }

    public ExchangeRate toModel(ExchangeRateDto dto) {
        ExchangeRate rate = new ExchangeRate();
        rate.setDate(dto.date());
        rate.setBuy(dto.buy());
        rate.setSale(dto.sale());
        rate.setCurrencyCode(dto.currencyCode());
        return rate;
    }
}
