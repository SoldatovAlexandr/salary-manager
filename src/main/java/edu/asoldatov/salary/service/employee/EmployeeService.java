package edu.asoldatov.salary.service.employee;

import edu.asoldatov.salary.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee get(Long id);

    Employee save(Employee employee);

    Collection<Employee> get();
}
