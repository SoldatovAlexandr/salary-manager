package edu.asoldatov.salary.model;

import edu.asoldatov.salary.common.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Employee {
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
}
