package com.samsung.evaluation.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class ConvertedCurrencyModel {
    private LocalDate documentDate;
    private String originalCurrencyCode;
    private double usdValue;
    private double penValue;
    private double brlValue;
}