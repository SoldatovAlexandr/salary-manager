package edu.strongsubgroup.salary;

import edu.strongsubgroup.salary.configuration.properties.EngineerCalculationsProperties;
import edu.strongsubgroup.salary.configuration.properties.ManagerCalculationsProperties;
import edu.strongsubgroup.salary.configuration.properties.SalaryTaxProperties;
import edu.strongsubgroup.salary.configuration.properties.WorkerCalculationsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({SalaryTaxProperties.class, EngineerCalculationsProperties.class,
        ManagerCalculationsProperties.class, WorkerCalculationsProperties.class})
@SpringBootApplication
public class SalaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalaryApplication.class, args);
    }

}
