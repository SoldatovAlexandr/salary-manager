package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Component
public class EngineerCalculateStrategy implements CalculateStrategy {

    @Value("${salary.amount.engineer.base}")
    private BigDecimal base;

    @Value("${salary.amount.engineer.grade}")
    private BigDecimal grade;

    @Value("${salary.tax.medical}")
    private BigDecimal medical;

    @Value("${salary.tax.ndfl}")
    private BigDecimal ndfl;

    @Value("${salary.tax.social}")
    private BigDecimal social;

    @Value("${salary.tax.retirement}")
    private BigDecimal retirement;

    private static final int FIRST_CHILD_RECOUPMENT = 1400;
    private static final int THIRD_CHILD_RECOUPMENT = 3000;

    @Override
    public Salary calculate(Employee employee) {
        BigDecimal wage = base.add(grade.multiply(employee.getCoefficient()));
        BigDecimal recoupment = calculateRecoupment(employee.getChildrenCount());
        BigDecimal calculatedNdfl = wage.subtract(recoupment)
                .multiply(ndfl)
                .scaleByPowerOfTen(-2)
                .setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal amount = wage.subtract(calculatedNdfl);

        return Salary.builder()
                .wage(wage)
                .amount(amount)
                .recoupment(recoupment)
                .ndfl(calculatedNdfl)
                .medical(wage.multiply(medical)
                        .scaleByPowerOfTen(-2)
                        .setScale(2, RoundingMode.HALF_EVEN))
                .social(wage.multiply(social)
                        .scaleByPowerOfTen(-2)
                        .setScale(2, RoundingMode.HALF_EVEN))
                .retirement(wage.multiply(retirement)
                        .scaleByPowerOfTen(-2)
                        .setScale(2, RoundingMode.HALF_EVEN))
                .employee(employee)
                .calculationDate(new Date()) // TODO: 12.09.2021 try with LocalDateTime, but could be problems with DB
                .build();
    }

    private BigDecimal calculateRecoupment(Integer count) {
        return new BigDecimal(String.valueOf(count < 3 ? FIRST_CHILD_RECOUPMENT * count :
                FIRST_CHILD_RECOUPMENT * 2 + (count - 2) * THIRD_CHILD_RECOUPMENT));
    }

    @Override
    public EmployeeType type() {
        return EmployeeType.ENGINEER;
    }
}
