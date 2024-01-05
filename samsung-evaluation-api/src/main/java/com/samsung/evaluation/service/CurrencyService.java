package com.samsung.evaluation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.samsung.evaluation.model.CurrencyModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Service
public class CurrencyService {
    
    private final RestTemplate restTemplate;
    private final String currencyApiUrl = "https://sdshealthcheck.cellologistics.com.br/sds-devs-evaluation/evaluation/currency";

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CurrencyModel> listAll() {
        ResponseEntity<List<CurrencyModel>> response = restTemplate.exchange(
            currencyApiUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<CurrencyModel>>() {});
        return response.getBody();
    }

    public CurrencyModel getCurrencyByCode(String currencyCode) {
        List<CurrencyModel> currencies = this.listAll();
        return currencies.stream()
                .filter(currency -> currency.getCurrencyCode().equalsIgnoreCase(currencyCode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Currency not found"));
    }
}
