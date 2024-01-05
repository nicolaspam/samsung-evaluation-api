package com.samsung.evaluation.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class QuotationModel {
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private double cotacao;
    private LocalDate dataHoraCotacao;

    }