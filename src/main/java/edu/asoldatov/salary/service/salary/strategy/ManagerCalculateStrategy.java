package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Manager;
import edu.asoldatov.salary.model.Salary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ManagerCalculateStrategy extends AbstractCalculateStrategy<Manager> {

    @Value("${salary.amount.manager.base}")
    private BigDecimal base;

    @Value("${salary.amount.manager.grade}")
    private BigDecimal grade;


    @Override
    public EmployeeType type() {
        return EmployeeType.MANAGER;
    }

    @Override
    protected BigDecimal calculateWage(Manager manager) {
        return base.add(grade.multiply(manager.getCoefficient()));
    }
}
