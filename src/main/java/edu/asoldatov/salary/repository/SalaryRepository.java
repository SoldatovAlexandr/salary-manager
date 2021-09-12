package edu.asoldatov.salary.repository;

import edu.asoldatov.salary.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
