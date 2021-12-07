package edu.strongsubgroup.salary.service.salary;

import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Salary;

public interface SalaryService {
    Salary calculate(Employee employee);

    void save(Salary salary);

}
