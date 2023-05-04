package com.example.exchangerateapp.service.impl;

import com.example.exchangerateapp.dto.ExchangeRateDto;
import com.example.exchangerateapp.dto.MonoBankRateDto;
import com.example.exchangerateapp.mapper.ExchangeRateMapper;
import com.example.exchangerateapp.mapper.MonoBankRateMapper;
import com.example.exchangerateapp.model.ExchangeRate;
import com.example.exchangerateapp.repository.ExchangeRateRepository;
import com.example.exchangerateapp.repository.MonoBankRepository;
import com.example.exchangerateapp.service.MonoBankService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MonoBankServiceImpl implements MonoBankService {
    private final MonoBankRepository monoBankRepository;
    private final MonoBankRateMapper monoBankRateMapper;
    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;
    @Value("${api.url.mono-bank}")
    private String monoUrl;

    @Override
    public void saveRates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(monoUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        MonoBankRateDto[] rates;
        try {
            rates = objectMapper.readValue(response.getBody(), MonoBankRateDto[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(
                    "Exception occurred while saving results from MonoBank url" + monoUrl, e);
        }
        for (MonoBankRateDto rate : rates) {
            if (rate.currencyCodeB() == 980) {
                monoBankRepository.save(monoBankRateMapper.toModel(rate));
                ExchangeRateDto exchangeRateDto = exchangeRateMapper.monoDtoToDto(rate);
                ExchangeRate exchangeRateModel = exchangeRateMapper.toModel(exchangeRateDto);
                exchangeRateRepository.save(exchangeRateModel);
            }
        }
    }
}
