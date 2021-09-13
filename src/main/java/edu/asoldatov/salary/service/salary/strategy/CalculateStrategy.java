package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;

public interface CalculateStrategy<T extends Employee> {

    Salary calculate(T t);

    EmployeeType type();
}
