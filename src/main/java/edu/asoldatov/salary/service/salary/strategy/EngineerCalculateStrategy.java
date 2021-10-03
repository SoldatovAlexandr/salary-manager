package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Engineer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//TODO: add config class for base and grade
@Getter
@Setter
@Component
public class EngineerCalculateStrategy extends AbstractCalculateStrategy<Engineer> {

    @Value("${salary.amount.engineer.base}")
    private BigDecimal base;

    @Value("${salary.amount.engineer.grade}")
    private BigDecimal grade;

    @Override
    public EmployeeType type() {
        return EmployeeType.ENGINEER;
    }

    @Override
    protected BigDecimal calculateWage(Engineer engineer) {
        return base.add(grade.multiply(engineer.getCoefficient()));
    }
}
