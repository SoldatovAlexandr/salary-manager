package edu.strongsubgroup.salary.service.salary;

import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Salary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SalaryService {
    Salary calculate(Employee employee);

    void save(Salary salary);

    Page<Salary> findAllByEmployee(Employee employee, Pageable pageable);
}
