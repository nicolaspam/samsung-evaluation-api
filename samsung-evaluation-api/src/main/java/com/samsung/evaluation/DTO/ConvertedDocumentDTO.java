package com.samsung.evaluation.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ConvertedDocumentDTO {

    private Integer documentId;
    private String documentNumber;
    private String notaFiscal;
    private LocalDate documentDate;
    private BigDecimal originalValue;
    private String originalCurrencyCode;
    private BigDecimal convertedValueUSD;
    private BigDecimal convertedValuePEN;
    private BigDecimal convertedValueBRL;
    
    private ConvertedDocumentDTO convertDocumentCurrency(DocumentDTO document, List<QuotationDTO> quotations) {
    ConvertedDocumentDTO convertedDocument = new ConvertedDocumentDTO();{
        BigDecimal originalValue = document.getDocumentValue();
    convertedDocument.setOriginalValue(originalValue);
    convertedDocument.setConvertedValueUSD(convertCurrency(originalValue, document.getCurrencyCode(), "USD", document.getDocumentDate()));
    convertedDocument.setConvertedValuePEN(convertCurrency(originalValue, document.getCurrencyCode(), "PEN", document.getDocumentDate()));
    convertedDocument.setConvertedValueBRL(convertCurrency(originalValue, document.getCurrencyCode(), "BRL", document.getDocumentDate()));
    
    }
}

    private BigDecimal convertCurrency(BigDecimal originalValue2, String currencyCode, String string,
            LocalDate documentDate2) {
        return null;
    }
