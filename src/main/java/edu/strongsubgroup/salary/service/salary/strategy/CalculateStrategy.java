package edu.strongsubgroup.salary.service.salary.strategy;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.model.Employee;

import java.math.BigDecimal;

public interface CalculateStrategy<T extends Employee> {

    int ZERO = 0;

    BigDecimal calculate(T t);

    EmployeeType type();
}
