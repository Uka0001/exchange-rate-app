package com.example.exchangerateapp.controller;

import com.example.exchangerateapp.dto.MonoBankRateDto;
import com.example.exchangerateapp.mapper.MonoBankRateMapper;
import com.example.exchangerateapp.service.MonoBankService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rates")
@AllArgsConstructor
public class ExchangeRatesController {
    private final MonoBankService monobankService;
    private final MonoBankRateMapper monoBankRateMapper;

    @GetMapping
    public List<MonoBankRateDto> getAverageRates(){
        return monobankService.getRates();
    }

    @GetMapping("/period")
    public List<MonoBankRateDto> getAverageRatesByPeriod(@RequestParam LocalDate startDate,
                                                         @RequestParam LocalDate finishDate){
        return monobankService.getRatesByPeriod(startDate, finishDate);
    }
}
