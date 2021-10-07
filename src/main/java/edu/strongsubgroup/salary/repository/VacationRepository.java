package edu.strongsubgroup.salary.repository;

import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {

    @Query("SELECT v FROM Vacation v WHERE v.beginning >= :date and v.employee = :employee")
    List<Vacation> findVacationByYearAndEmployee(@Param("employee") Employee employee, @Param("date") LocalDate date);
}
