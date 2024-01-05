package com.samsung.evaluation.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentDTO {
    private Integer documentId;
    private String documentNumber;
    private String notaFiscal;
    private LocalDate documentDate;
    private BigDecimal documentValue;
    private String currencyCode;
    
}
