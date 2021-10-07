package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Manager;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Setter
@Component
public class ManagerCalculateStrategy implements CalculateStrategy <Manager> {

    @Value("${salary.amount.manager.base}")
    private BigDecimal base;

    @Value("${salary.amount.manager.grade}")
    private BigDecimal grade;

    @Override
    public EmployeeType type() {
        return EmployeeType.MANAGER;
    }

    @Override
    public BigDecimal calculate(Manager manager) {
        BigDecimal wageFromProjects = calculateWageFromProjects(manager);
        return wageFromProjects.compareTo(base) > ZERO ? wageFromProjects : base;
    }

    private BigDecimal calculateWageFromProjects(Manager manager) {
        return grade.multiply(manager.getCoefficient())
                .multiply(BigDecimal.valueOf(manager.getCountOfProjects()));
    }
}
