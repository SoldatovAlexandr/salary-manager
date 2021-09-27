package edu.asoldatov.salary.repository;

import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {

    @Query("SELECT v FROM Vacation v WHERE v.beginning >= :date and v.employee = :employee and v.status = 'CONFIRMED'")
    List<Vacation> findVacationByYearAndEmployee(@Param("employee") Employee employee, @Param("date") LocalDate date);
}
