package edu.strongsubgroup.salary.repository;

import edu.strongsubgroup.salary.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
