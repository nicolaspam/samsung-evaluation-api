package com.samsung.evaluation.DTO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsung.evaluation.model.CurrencyModel;
import java.io.IOException;
import java.util.List;

public class CurrencyDTO {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<CurrencyModel> dataToModel(String json) throws IOException {
        return objectMapper.readValue(json, new TypeReference<List<CurrencyModel>>(){});
    }

    public static CurrencyModel dataToModelByCode(String json, String currencyCodeParam) throws IOException {
        List<CurrencyModel> currencies = dataToModel(json);
        return currencies.stream()
                .filter(currency -> currencyCodeParam.equalsIgnoreCase(currency.getCurrencyCode()))
                .findFirst()
                .orElse(null);
    }
}
