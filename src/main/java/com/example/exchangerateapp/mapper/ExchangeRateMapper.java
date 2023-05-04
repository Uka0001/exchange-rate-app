package com.example.exchangerateapp.mapper;

import com.example.exchangerateapp.dto.ExchangeRateDto;
import com.example.exchangerateapp.dto.MinfinRateDto;
import com.example.exchangerateapp.dto.MonoBankRateDto;
import com.example.exchangerateapp.dto.PrivatBankRateDto;
import com.example.exchangerateapp.model.CCU;
import com.example.exchangerateapp.model.ExchangeRate;
import com.example.exchangerateapp.model.MinfinRate;
import com.example.exchangerateapp.model.MonoBankRate;
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
    public ExchangeRateDto minfinModelToDto(MinfinRate model) {
        String dateTimeString = model.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString, formatter);
        LocalDate localDate = zonedDateTime.toLocalDate();
        return new ExchangeRateDto(
                model.getId(),
                localDate,
                model.getAsk(),
                model.getDesk(),
                model.getCurrency()
        );
    }

    public ExchangeRateDto minfinDtoToDto(MinfinRateDto dto) {
        String dateTimeString = dto.date();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString, formatter);
        LocalDate localDate = zonedDateTime.toLocalDate();
        return new ExchangeRateDto(
                dto.id(),
                localDate,
                dto.ask(),
                dto.bid(),
                Integer.parseInt(dto.currency())
        );
    }

    public ExchangeRateDto monoModelToDto(MonoBankRate model) {
        Instant instant = Instant.ofEpochSecond(model.getDate());
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.UTC);
        LocalDate localDate = offsetDateTime.toLocalDate();
        float buy = model.getRateBuy() > 0 ? model.getRateBuy() : model.getRateCross();
        float sale = model.getRateSell() > 0 ? model.getRateSell() : model.getRateCross();
        return new ExchangeRateDto(
                model.getId(),
                localDate,
                buy,
                sale,
                model.getCurrencyCodeA()
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
                CCU.valueOf(codeCcy).getCode()
        );
    }

    public ExchangeRateDto privatDtoToDto(PrivatBankRateDto dto) {
        String codeCcy = dto.ccy();
        String dateTimeString = dto.date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDate date = dateTime.toLocalDate();
        return new ExchangeRateDto(
                dto.id(),
                date,
                dto.buy(),
                dto.sale(),
                CCU.valueOf(codeCcy).getCode()
        );
    }

    public ExchangeRate toModel(ExchangeRateDto dto) {
        ExchangeRate rate = new ExchangeRate();
//        rate.setId(dto.id());
        rate.setDate(dto.date());
        rate.setBuy(dto.buy());
        rate.setSale(dto.sale());
        rate.setCurrencyCode(dto.currencyCode());
        return rate;
    }

    public ExchangeRateDto toDto(ExchangeRate model) {
        return new ExchangeRateDto(
                model.getId(),
                model.getDate(),
                model.getBuy(),
                model.getSale(),
                model.getCurrencyCode()
        );
    }
}
