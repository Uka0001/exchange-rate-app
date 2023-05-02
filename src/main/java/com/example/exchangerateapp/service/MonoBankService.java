package com.example.exchangerateapp.service;

import com.example.exchangerateapp.dto.MonoBankRateDto;

import java.time.LocalDate;
import java.util.List;

public interface MonoBankService {

    void saveRates();

    List<MonoBankRateDto> getRates();

    List<MonoBankRateDto> getRatesByPeriod(LocalDate start, LocalDate finish);
}
