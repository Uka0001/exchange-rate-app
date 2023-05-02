package com.example.exchangerateapp.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.example.exchangerateapp.dto.MonoBankRateDto;
import com.example.exchangerateapp.mapper.MonoBankRateMapper;
import com.example.exchangerateapp.model.MonoBankRate;
import com.example.exchangerateapp.repository.MonoBankRepository;
import com.example.exchangerateapp.service.MonoBankService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
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
    @Value("${api.url.mono-bank}")
    private static String monoUrl;

    @Override
    public void saveRates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(monoUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        MonoBankRate[] rates;
        try {
            rates = objectMapper.readValue(response.getBody(), MonoBankRate[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (MonoBankRate rate : rates) {
            monoBankRepository.save(rate);
        }
    }

    @Override
    public List<MonoBankRateDto> getRates() {
        return monoBankRepository.findAll().stream()
                .map(rate -> monoBankRateMapper.toDto(rate))
                .toList();
    }

    @Override
    public List<MonoBankRateDto> getRatesByPeriod(LocalDate start, LocalDate finish) {
        return monoBankRepository.findAll().stream()
                .map(rate -> monoBankRateMapper.toDto(rate))
                .toList();
    }


}
