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
@Table(name = "minfin_rates")
public class MinfinRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pointDate;
    private String date;
    private float ask;
    private float bid;
    private float desk;
    private float trendAsk;
    private float trendBid;
    private String currency;
    private String comment;
}
