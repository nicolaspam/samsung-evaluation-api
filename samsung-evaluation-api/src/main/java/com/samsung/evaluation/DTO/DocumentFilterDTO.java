package com.samsung.evaluation.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentFilterDTO {
    private String documentNumber;
    private String currencyCode;
    private LocalDate documentDate;
}
