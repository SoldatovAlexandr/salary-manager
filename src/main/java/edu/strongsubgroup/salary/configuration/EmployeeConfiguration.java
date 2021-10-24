package edu.strongsubgroup.salary.configuration;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.service.salary.strategy.CalculateStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

@Configuration
public class EmployeeConfiguration {

    @Bean
    public EnumMap<EmployeeType, CalculateStrategy> calculateStrategy(List<CalculateStrategy> calculateStrategies) {
        EnumMap<EmployeeType, CalculateStrategy> map = new EnumMap<>(EmployeeType.class);
        calculateStrategies.forEach(s -> map.put(s.type(), s));
        return map;
    }

    @Bean
    public SalaryConfig salaryConfig() {
        return SalaryConfig.builder()
                .medical(BigDecimal.ONE)
                .ndfl(BigDecimal.TEN)
                .retirement(BigDecimal.TEN)
                .social(BigDecimal.TEN)
                .build();
    }
}
