package com.samsung.evaluation.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.samsung.evaluation.DTO.QuotationDTO;
import com.samsung.evaluation.model.QuotationModel;

import java.util.List;

@Service
public class QuotationService {

    private final RestTemplate restTemplate;
    private final String quotationApiUrl = "https://sdshealthcheck.cellologistics.com.br/sds-devs-evaluation/evaluation/quotation";

    public QuotationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    

    public List<QuotationDTO> getQuotationInfo() {
        ResponseEntity<List<QuotationDTO>> response = restTemplate.exchange(
                quotationApiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<QuotationDTO>>() {});
        return response.getBody();
    }

    public List<QuotationModel> listAll() {
        ResponseEntity<List<QuotationModel>> response = restTemplate.exchange(
                quotationApiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<QuotationModel>>() {});
        return response.getBody();
    }
}
