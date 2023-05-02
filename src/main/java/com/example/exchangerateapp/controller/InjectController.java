package com.example.exchangerateapp.controller;

import com.example.exchangerateapp.service.MinfinService;
import com.example.exchangerateapp.service.MonoBankService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class InjectController {
    private final MonoBankService monoBankService;
    private final MinfinService minfinService;

    @PostConstruct
    public void init() {
        monoBankService.saveRates();
        minfinService.saveRates();
    }
}
