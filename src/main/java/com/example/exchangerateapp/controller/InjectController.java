package com.example.exchangerateapp.controller;

import com.example.exchangerateapp.service.MinfinService;
import com.example.exchangerateapp.service.MonoBankService;
import com.example.exchangerateapp.service.PrivatBankService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class InjectController {
    private final MonoBankService monoBankService;
    private final MinfinService minfinService;
    private final PrivatBankService privatBankService;

    @Scheduled(cron = "0 */5 * ? * *")
    @PostConstruct
    public void init() {
        monoBankService.saveRates();
        minfinService.saveRates();
        privatBankService.saveRates();
    }
}
