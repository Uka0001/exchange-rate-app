package com.example.exchangerateapp.model;

public enum CCU {
    EUR(980),
    USD(840);

    private final int code;

    CCU(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
