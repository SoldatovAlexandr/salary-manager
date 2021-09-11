package edu.asoldatov.salary.service.salary;

import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;

public interface SalaryService {
    Salary calculate(Employee employee);
}
