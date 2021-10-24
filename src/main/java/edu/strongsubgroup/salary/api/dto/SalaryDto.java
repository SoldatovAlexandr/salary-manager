package edu.strongsubgroup.salary.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class SalaryDto {

    private Long id;
    private BigDecimal wage;
    private BigDecimal amount;
    private BigDecimal recoupment;
    private BigDecimal ndfl;
    private BigDecimal retirement;
    private BigDecimal medical;
    private BigDecimal social;
    // private Employee employee;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime calculationDate;
}
