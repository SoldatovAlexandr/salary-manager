package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

@Component
public class ManagerCalculateStrategy implements CalculateStrategy {

    @Value("${salary.amount.manager}")
    private BigDecimal amount;

    @Override
    public Salary calculate(Employee employee) {
        return Salary.builder().amount(amount).build();
    }

    @Override
    public EmployeeType type() {
        return EmployeeType.MANAGER;
    }
}
