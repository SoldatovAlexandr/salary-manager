package edu.strongsubgroup.salary.configuration.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "salary.tax")
public class SalaryTaxProperties {

    private BigDecimal medical;
    private BigDecimal ndfl;
    private BigDecimal social;
    private BigDecimal retirement;

}
