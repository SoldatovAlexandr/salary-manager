package edu.strongsubgroup.salary.repository;

import edu.strongsubgroup.salary.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    @Query(value = "SELECT * FROM employee WHERE id NOT IN " +
            "(SELECT employee_id FROM salary WHERE DATE(calculation_date) = CURRENT_DATE) " +
            "LIMIT :limit FOR UPDATE SKIP LOCKED ",
            nativeQuery = true)
    Collection<Employee> findUnCalculated(Long limit);
}
