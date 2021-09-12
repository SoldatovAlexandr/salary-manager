package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ManagerCalculateStrategy implements CalculateStrategy {

    @Value("${salary.amount.manager.base}")
    private BigDecimal base;

    @Override
    public Salary calculate(Employee employee) {
        return Salary.builder().amount(base).build();
    }

    @Override
    public EmployeeType type() {
        return EmployeeType.MANAGER;
    }
}
