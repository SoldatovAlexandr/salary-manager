package edu.strongsubgroup.salary.configuration.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "app.job-properties.calculate-salary")
public class CalculateSalaryJobProperties {

    private Long fixedDelay;
    private Long initialDelay;
    private Long limit;

}
