package com.samsung.evaluation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.evaluation.DTO.DocumentDTO;
import com.samsung.evaluation.model.CurrencyModel;
import com.samsung.evaluation.model.QuotationModel;
import com.samsung.evaluation.service.CurrencyService;
import com.samsung.evaluation.service.DocumentService;
import com.samsung.evaluation.service.QuotationService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private QuotationService quotationService;

    @Autowired
    private DocumentService docsService;
    
    @GetMapping("/currencies")
    public List<CurrencyModel> getAllCurrencies() {
        List<CurrencyModel> currencies = currencyService.listAll();
        return currencies;
    }

    @GetMapping("/currency")
    public CurrencyModel getCurrencyByCode(@RequestParam String currencyCode) {
        CurrencyModel currency = currencyService.getCurrencyByCode(currencyCode);
        return currency;
    }

    @GetMapping("/quotations")
    public List<QuotationModel> getAllQuotations() {
        List<QuotationModel> quotations = quotationService.listAll();
        return quotations;
    }

    @GetMapping("/documents")
    public List<DocumentDTO> getAllDocuments() {
        List<DocumentDTO> documents = docsService.listAll();
        return documents;
    }
}
