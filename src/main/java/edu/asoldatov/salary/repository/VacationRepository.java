package edu.asoldatov.salary.repository;

import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {

    @Query("SELECT v FROM Vacation v WHERE v.")
    List<Vacation> findVacationByYearAndEmployee(Employee employee, Date date);
}
