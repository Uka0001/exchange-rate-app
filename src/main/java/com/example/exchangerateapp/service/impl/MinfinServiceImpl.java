package com.example.exchangerateapp.service.impl;

import com.example.exchangerateapp.mapper.MinfinRateMapper;
import com.example.exchangerateapp.model.MinfinRate;
import com.example.exchangerateapp.model.MonoBankRate;
import com.example.exchangerateapp.repository.MinfinRepository;
import com.example.exchangerateapp.service.MinfinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class MinfinServiceImpl implements MinfinService {
    private final MinfinRepository minfinRepository;
    private final MinfinRateMapper minfinRateMapper;

    @Override
    public void saveRates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity("https://api.minfin.com.ua/mb/1fc46cc4b21517f304f9b033cb087c8527a9ccaf/", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        MinfinRate[] rates;
        try {
            rates = objectMapper.readValue(response.getBody(), MinfinRate[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (MinfinRate rate: rates) {
            minfinRepository.save(rate);
        }
    }
}
