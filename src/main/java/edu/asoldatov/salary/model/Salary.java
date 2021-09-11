package edu.asoldatov.salary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class Salary {
    private BigDecimal amount;
    private BigDecimal recoupment;
    private BigDecimal ndfl;
    private BigDecimal retirement;
    private BigDecimal medical;
    private BigDecimal social;
}
