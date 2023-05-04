package com.example.exchangerateapp.service.impl;

import com.example.exchangerateapp.dto.ResultRateDto;
import com.example.exchangerateapp.mapper.ExchangeRateMapper;
import com.example.exchangerateapp.mapper.MinfinRateMapper;
import com.example.exchangerateapp.mapper.ResultRateMapper;
import com.example.exchangerateapp.repository.ExchangeRateRepository;
import com.example.exchangerateapp.repository.MinfinRepository;
import com.example.exchangerateapp.repository.MonoBankRepository;
import com.example.exchangerateapp.repository.PrivatBankRepository;
import com.example.exchangerateapp.service.ExchangeRatesService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRatesServiceImpl implements ExchangeRatesService {
    private final MinfinRepository minfinRepository;
    private final MinfinRateMapper minfinRateMapper;
    private final MonoBankRepository monoBankRepository;
    private final PrivatBankRepository privatBankRepository;
    private final ExchangeRateMapper mapper;
    private final ResultRateMapper rateMapper;
    private final ExchangeRateRepository exchangeRateRepository;

    @Override
    public List<ResultRateDto> getAverageRates() {
        return exchangeRateRepository.findAllAverageRates().stream()
                .map(model -> rateMapper.rateDto(model))
                .toList();
    }

    @Override
    public List<ResultRateDto> getAverageRatesByPeriod(LocalDate startDate, LocalDate endDate) {
        return exchangeRateRepository.findAllAverageRatesByPeriod(startDate, endDate).stream()
                .map(model -> rateMapper.rateDto(model))
                .toList();
    }
}
