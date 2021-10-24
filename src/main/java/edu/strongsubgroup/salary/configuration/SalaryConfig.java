package edu.strongsubgroup.salary.configuration;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
public class SalaryConfig {

    //@Value("${salary.tax.medical}")
    private BigDecimal medical;

    //@Value("${salary.tax.ndfl}")
    private BigDecimal ndfl;

    //@Value("${salary.tax.social}")
    private BigDecimal social;

    //@Value("${salary.tax.retirement}")
    private BigDecimal retirement;

}
