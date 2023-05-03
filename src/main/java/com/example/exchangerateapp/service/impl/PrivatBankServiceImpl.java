package com.example.exchangerateapp.service.impl;

import com.example.exchangerateapp.dto.PrivatBankRateDto;
import com.example.exchangerateapp.mapper.PrivatBankRateMapper;
import com.example.exchangerateapp.repository.PrivatBankRepository;
import com.example.exchangerateapp.service.PrivatBankService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PrivatBankServiceImpl implements PrivatBankService {
    private final PrivatBankRepository privatBankRepository;
    private final PrivatBankRateMapper privatBankRateMapper;

    @Value("${api.url.privat-bank}")
    private String privatUrl;

    @Override
    public void saveRates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(privatUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        PrivatBankRateDto[] rates;
        try {
            rates = objectMapper.readValue(response.getBody(), PrivatBankRateDto[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(
                    "Exception occurred while saving results from PrivatBank url: " + privatUrl, e);
        }
        for (PrivatBankRateDto rate : rates) {
            privatBankRepository.save(privatBankRateMapper.toModel(rate));
        }
    }
}
