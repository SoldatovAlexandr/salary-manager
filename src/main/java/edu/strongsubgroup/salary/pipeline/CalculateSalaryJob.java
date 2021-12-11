package edu.strongsubgroup.salary.pipeline;

import edu.strongsubgroup.salary.configuration.properties.CalculateSalaryJobProperties;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Salary;
import edu.strongsubgroup.salary.service.employee.EmployeeService;
import edu.strongsubgroup.salary.service.salary.SalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Component
public class CalculateSalaryJob {

    private final SalaryService salaryService;
    private final EmployeeService employeeService;
    private final CalculateSalaryJobProperties jobProperties;

    @Scheduled(initialDelayString = "${app.job-properties.calculate-salary.initial-delay}",
            fixedDelayString = "${app.job-properties.calculate-salary.fixed-delay}")
    public void calculateSalary() {
        Collection<Employee> employees = employeeService.findUnCalculated(jobProperties.getLimit());

        for (Employee employee : employees) {
            Salary salary = salaryService.calculate(employee);
            salaryService.save(salary);
        }
    }
}
