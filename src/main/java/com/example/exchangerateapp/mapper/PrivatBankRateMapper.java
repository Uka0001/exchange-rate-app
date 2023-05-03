package com.example.exchangerateapp.mapper;

import com.example.exchangerateapp.dto.PrivatBankRateDto;
import com.example.exchangerateapp.model.PrivatBankRate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PrivatBankRateMapper {
    public PrivatBankRateDto toDto(PrivatBankRate model) {
        return new PrivatBankRateDto(
                model.getId(),
                model.getCcy(),
                model.getBase_ccy(),
                model.getBuy(),
                model.getSale(),
                model.getDate()
        );
    }

    public PrivatBankRate toModel(PrivatBankRateDto dto) {
        PrivatBankRate privatBankRate = new PrivatBankRate();
        privatBankRate.setId(dto.id());
        privatBankRate.setBase_ccy(dto.base_ccy());
        privatBankRate.setCcy(dto.ccy());
        privatBankRate.setSale(dto.sale());
        privatBankRate.setBuy(dto.buy());
        privatBankRate.setDate(LocalDateTime.now().toString());
        return privatBankRate;
    }
}
