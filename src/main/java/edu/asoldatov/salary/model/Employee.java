package edu.asoldatov.salary.model;

import edu.asoldatov.salary.common.EmployeeType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private BigDecimal coefficient;
    private Integer childrenCount;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEmployment;
    private EmployeeType type;
    private List<Salary> salaries;
    private List<Vacation> vacations;
    private List<DayOff> dayOffs;
    private Long extraVacationDays;
}
