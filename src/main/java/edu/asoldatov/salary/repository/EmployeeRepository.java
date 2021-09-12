package edu.asoldatov.salary.repository;

import edu.asoldatov.salary.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
