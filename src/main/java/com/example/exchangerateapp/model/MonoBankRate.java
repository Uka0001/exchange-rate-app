package com.example.exchangerateapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "mono_bank_rates")
public class MonoBankRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int currencyCodeA;
    private int currencyCodeB;
    private long date;
    private float  rateSell;
    private float  rateBuy;
    private float  rateCross;
}
