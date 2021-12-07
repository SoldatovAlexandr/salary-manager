package edu.strongsubgroup.salary.service.employee;

import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.repository.specification.EmployeeSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface EmployeeService {
    Employee findById(Long id);

    void save(Employee employee);

    Page<Employee> findBySpecification(EmployeeSpecification specification, Pageable pageable);

    Collection<Employee> findUnCalculated(Long limit);
}
