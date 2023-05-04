package com.example.exchangerateapp.model;

public enum CurrencyCode {
    EUR(980),
    USD(840);

    private final int code;

    CurrencyCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
