package edu.strongsubgroup.salary;

import edu.strongsubgroup.salary.configuration.properties.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({SalaryTaxProperties.class, EngineerCalculationsProperties.class,
        ManagerCalculationsProperties.class, WorkerCalculationsProperties.class, CalculateSalaryJobProperties.class})
@SpringBootApplication
public class SalaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalaryApplication.class, args);
    }

}
