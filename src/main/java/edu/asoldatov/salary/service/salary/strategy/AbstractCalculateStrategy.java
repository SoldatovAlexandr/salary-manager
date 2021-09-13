package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class AbstractCalculateStrategy<T extends Employee> implements CalculateStrategy<T> {

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
    public Salary calculate(T employee) {
        BigDecimal wage = calculateWage(employee);
        BigDecimal recoupment = calculateRecoupment(employee.getChildrenCount());
        BigDecimal calculatedNdfl = multiply(wage.subtract(recoupment), ndfl);

        return Salary.builder()
                .wage(wage)
                .amount(wage.subtract(calculatedNdfl))
                .recoupment(recoupment)
                .ndfl(calculatedNdfl)
                .medical(multiply(wage, medical))
                .social(multiply(wage, social))
                .retirement(multiply(wage, retirement))
                .employee(employee)
                .calculationDate(LocalDateTime.now()) // TODO: 12.09.2021 try with LocalDateTime, but could be problems with DB
                .build();
    }

    private BigDecimal calculateRecoupment(Integer count) {
        return new BigDecimal(String.valueOf(count < 3 ?
                FIRST_CHILD_RECOUPMENT * count :
                FIRST_CHILD_RECOUPMENT * 2 + (count - 2) * THIRD_CHILD_RECOUPMENT));
    }

    private BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return first.multiply(second)
                .scaleByPowerOfTen(-2)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    protected abstract BigDecimal calculateWage(T employee);
}
