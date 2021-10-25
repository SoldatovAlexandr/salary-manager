package edu.strongsubgroup.salary.repository;

import edu.strongsubgroup.salary.model.DayOff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;

public interface DayOffRepository extends JpaRepository<DayOff, Long> {

    long countDayOffByDateAfterAndDateBefore(LocalDate before, LocalDate after);
}
