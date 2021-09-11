package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;

import java.math.BigDecimal;

public interface CalculateStrategy {

    Salary calculate(Employee employee);

    EmployeeType type();
}
