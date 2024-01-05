package com.samsung.evaluation.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DocumentModel {
    private int documentId;
    private String documentNumber;
    private String notaFiscal;
    private LocalDate documentDate;
    private double documentValue;
    private String currencyCode;
}