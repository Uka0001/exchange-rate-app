package com.example.exchangerateapp.controller;

import com.example.exchangerateapp.dto.ExchangeRateDto;
import com.example.exchangerateapp.dto.MonoBankRateDto;
import com.example.exchangerateapp.dto.ResultRateDto;
import com.example.exchangerateapp.mapper.ExchangeRateMapper;
import com.example.exchangerateapp.mapper.MonoBankRateMapper;
import com.example.exchangerateapp.service.ExchangeRatesService;
import com.example.exchangerateapp.service.MonoBankService;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rates")
@RequiredArgsConstructor
public class ExchangeRatesController {
    private final ExchangeRatesService exchangeRatesService;

    @GetMapping
    public List<ResultRateDto> getAverageRates(){
        return exchangeRatesService.getAverageRates();
    }

    @GetMapping("/period")
    public List<ResultRateDto> getAverageRatesByPeriod(@RequestParam LocalDate startDate,
                                                         @RequestParam LocalDate finishDate){
        return exchangeRatesService.getAverageRatesByPeriod(startDate, finishDate);
    }
}
