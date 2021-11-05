package edu.strongsubgroup.salary.service.salary.strategy;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.configuration.properties.ManagerCalculationsProperties;
import edu.strongsubgroup.salary.model.Manager;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Setter
@Component
public class ManagerCalculateStrategy implements CalculateStrategy<Manager> {

    private final ManagerCalculationsProperties properties;

    @Override
    public EmployeeType type() {
        return EmployeeType.MANAGER;
    }

    @Override
    public BigDecimal calculate(Manager manager) {
        BigDecimal wageFromProjects = calculateWageFromProjects(manager);
        return wageFromProjects.compareTo(properties.getBase()) > ZERO ? wageFromProjects : properties.getBase();
    }

    private BigDecimal calculateWageFromProjects(Manager manager) {
        return properties.getGrade().multiply(manager.getCoefficient())
                .multiply(BigDecimal.valueOf(manager.getCountOfProjects()));
    }
}
