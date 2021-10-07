package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Employee;

import java.math.BigDecimal;

public interface CalculateStrategy<T extends Employee> {

    int ZERO = 0;

    BigDecimal calculate(T t);

    EmployeeType type();
}
