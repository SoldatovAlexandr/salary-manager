package edu.asoldatov.salary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class Salary {
    private BigDecimal wage;
    private BigDecimal amount;
    private BigDecimal recoupment;
    private BigDecimal ndfl;
    private BigDecimal retirement;
    private BigDecimal medical;
    private BigDecimal social;
    private Employee employee;
    private Date calculationDate;
}
