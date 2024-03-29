package com.samsung.evaluation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.samsung.evaluation.DTO.DocumentDTO;
import com.samsung.evaluation.DTO.DocumentFilterDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private final RestTemplate restTemplate;
    private final String documentApiUrl = "https://sdshealthcheck.cellologistics.com.br/sds-devs-evaluation/evaluation/docs";

    public DocumentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<DocumentDTO> getFilteredDocuments(DocumentFilterDTO filters) {
        ResponseEntity<List<DocumentDTO>> response = restTemplate.exchange(
                documentApiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DocumentDTO>>() {});
        List<DocumentDTO> allDocuments = response.getBody();

        if (filters != null) {
            if (filters.getDocumentNumber() != null) {
                allDocuments = allDocuments.stream()
                        .filter(d -> d.getDocumentNumber().equals(filters.getDocumentNumber()))
                        .collect(Collectors.toList());
            }
            if (filters.getCurrencyCode() != null) {
                allDocuments = allDocuments.stream()
                        .filter(d -> d.getCurrencyCode().equals(filters.getCurrencyCode()))
                        .collect(Collectors.toList());
            }
            if (filters.getDocumentDate() != null) {
                allDocuments = allDocuments.stream()
                        .filter(d -> d.getDocumentDate().equals(filters.getDocumentDate()))
                        .collect(Collectors.toList());
            }
        }

        return allDocuments;
    }

public List<DocumentDTO> listAll() {
    ResponseEntity<List<DocumentDTO>> response = restTemplate.exchange(
            documentApiUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<DocumentDTO>>() {});
    return response.getBody();
}

}
