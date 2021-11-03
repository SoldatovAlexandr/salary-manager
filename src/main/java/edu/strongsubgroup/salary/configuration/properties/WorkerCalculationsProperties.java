package edu.strongsubgroup.salary.configuration.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "salary.amount.worker")
public class WorkerCalculationsProperties {

    private BigDecimal base;
    private BigDecimal grade;

}
