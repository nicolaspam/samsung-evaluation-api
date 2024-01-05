package com.samsung.evaluation.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuotationDTO {
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private BigDecimal cotacao;
    private LocalDate dataHoraCotacao;

    private QuotationDTO findRelevantQuotation(List<QuotationDTO> quotations, LocalDate documentDate, String currencyCode) {
    return quotations.stream()
            .filter(q -> q.getDataHoraCotacao().isBefore(documentDate.plusDays(1)))
            .filter(q -> q.getFromCurrencyCode().equals(currencyCode) || q.getToCurrencyCode().equals(currencyCode))
            .max((q1, q2) -> q1.getDataHoraCotacao().compareTo(q2.getDataHoraCotacao()))
            .orElse(null);
}

}
