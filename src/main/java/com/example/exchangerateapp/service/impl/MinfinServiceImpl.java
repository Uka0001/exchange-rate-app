package com.example.exchangerateapp.service.impl;

import com.example.exchangerateapp.dto.ExchangeRateDto;
import com.example.exchangerateapp.dto.MinfinRateDto;
import com.example.exchangerateapp.mapper.ExchangeRateMapper;
import com.example.exchangerateapp.mapper.MinfinRateMapper;
import com.example.exchangerateapp.model.ExchangeRate;
import com.example.exchangerateapp.repository.ExchangeRateRepository;
import com.example.exchangerateapp.repository.MinfinRepository;
import com.example.exchangerateapp.service.MinfinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MinfinServiceImpl implements MinfinService {
    private final MinfinRepository minfinRepository;
    private final MinfinRateMapper minfinRateMapper;
    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;
    @Value("${api.url.min-fin}")
    private String minfinUrl;

    @Override
    public void saveRates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(minfinUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        MinfinRateDto[] rates;
        try {
            rates = objectMapper.readValue(response.getBody(), MinfinRateDto[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(
                    "Exception occurred while saving results from MinFin url:" + minfinUrl, e);
        }
        for (MinfinRateDto rate: rates) {
            minfinRepository.save(minfinRateMapper.toModel(rate));
            ExchangeRateDto exchangeRateDto = exchangeRateMapper.minfinDtoToDto(rate);
            ExchangeRate exchangeRateModel = exchangeRateMapper.toModel(exchangeRateDto);
            exchangeRateRepository.save(exchangeRateModel);
        }
    }
}
