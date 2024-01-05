package com.samsung.evaluation.service;

import org.springframework.stereotype.Service;

import com.samsung.evaluation.DTO.DocumentDTO;
import com.samsung.evaluation.DTO.QuotationDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyConversionService {

    private final QuotationService quotationService;

    public CurrencyConversionService(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    public List<DocumentDTO> convertDocumentCurrencies(List<DocumentDTO> documents) {
        List<QuotationDTO> quotations = quotationService.getQuotationInfo();
        
        return documents.stream()
                .map(document -> convertDocumentCurrency(document, quotations))
                .collect(Collectors.toList());
    }

    private DocumentDTO convertDocumentCurrency(DocumentDTO document, List<QuotationDTO> quotations) {
        QuotationDTO relevantQuotation = findRelevantQuotation(quotations, document.getDocumentDate(), document.getCurrencyCode());
        
        if (relevantQuotation != null) {
            BigDecimal conversionRate = getConversionRate(relevantQuotation, document.getCurrencyCode());
            BigDecimal convertedValue = document.getDocumentValue().multiply(conversionRate);
            document.setDocumentValue(convertedValue);
        }

        return document;
    }

    private QuotationDTO findRelevantQuotation(List<QuotationDTO> quotations, LocalDate documentDate, String currencyCode) {
        return quotations.stream()
                .filter(q -> !q.getDataHoraCotacao().isAfter(documentDate))
                .filter(q -> q.getFromCurrencyCode().equals(currencyCode) || q.getToCurrencyCode().equals(currencyCode))
                .max((q1, q2) -> q1.getDataHoraCotacao().compareTo(q2.getDataHoraCotacao()))
                .orElse(null);
    }
    

   private BigDecimal getConversionRate(QuotationDTO quotation, String targetCurrencyCode) {
    if (quotation.getFromCurrencyCode().equals(targetCurrencyCode)) {
        return BigDecimal.ONE.divide(quotation.getCotacao(), 4, RoundingMode.HALF_UP);
    } else if (quotation.getToCurrencyCode().equals(targetCurrencyCode)) {
        return quotation.getCotacao();
    }
    return BigDecimal.ONE;
}

}
