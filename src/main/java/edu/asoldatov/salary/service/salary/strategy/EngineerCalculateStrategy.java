package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EngineerCalculateStrategy implements CalculateStrategy {

    @Value("${salary.amount.engineer.base}")
    private BigDecimal base;

    @Value("${salary.amount.engineer.grade}")
    private BigDecimal grade;

    private static final int FIRST_CHILD_RECOUPMENT = 1400;
    private static final int THIRD_CHILD_RECOUPMENT = 3000;

    @Override
    public Salary calculate(Employee employee) {
        BigDecimal wage = base.add(grade.multiply(employee.getCoefficient()));
        BigDecimal recoupment = calculateRecoupment(employee.getChildrenCount());
        BigDecimal amount = wage.remainder(recoupment).multiply(new BigDecimal("0.87"));

        return Salary.builder()
                .amount(amount)
                .recoupment(recoupment)
                .medical(wage.multiply(new BigDecimal("0.99")))//TODO:set current coefficient
                .ndfl(wage.multiply(new BigDecimal("0.99")))
                .social(wage.multiply(new BigDecimal("0.99")))
                .build();
    }

    private BigDecimal calculateRecoupment(Integer count) {
        return new BigDecimal(String.valueOf(count < 3 ? 1400 * count : 2800 + (count - 2) * 3000));
    }

    @Override
    public EmployeeType type() {
        return EmployeeType.ENGINEER;
    }
}
