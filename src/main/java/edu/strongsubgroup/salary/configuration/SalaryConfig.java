package edu.strongsubgroup.salary.configuration;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Исправить на нормальный класс конфиг
 * Было очень лень делать нормально
 */

@Builder
@Setter
@Getter
@Component
public class SalaryConfig {

    @Value("${salary.tax.medical}")
    private BigDecimal medical;

    @Value("${salary.tax.ndfl}")
    private BigDecimal ndfl;

    @Value("${salary.tax.social}")
    private BigDecimal social;

    @Value("${salary.tax.retirement}")
    private BigDecimal retirement;

}
