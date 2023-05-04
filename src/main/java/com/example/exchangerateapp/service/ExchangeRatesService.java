package com.example.exchangerateapp.service;

import com.example.exchangerateapp.dto.ResultRateDto;
import java.time.LocalDate;
import java.util.List;

public interface ExchangeRatesService {
    List<ResultRateDto> getAverageRates();

    List<ResultRateDto> getAverageRatesByPeriod(LocalDate startDate, LocalDate endDate);
}
