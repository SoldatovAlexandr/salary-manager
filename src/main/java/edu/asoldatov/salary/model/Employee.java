package edu.asoldatov.salary.model;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.common.Gender;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Employee extends AbstractPersistable<Long> {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "coefficient")
    private BigDecimal coefficient;

    @Column(name = "children_count")
    private Integer childrenCount;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "date_of_employment")
    private LocalDate dateOfEmployment;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private EmployeeType type;

    @OneToMany
    private List<Salary> salaries;

    @OneToMany
    private List<Vacation> vacations;

    @OneToMany
    private List<DayOff> dayOffs;

    @Column(name = "extra_vacation_days")
    private Long extraVacationDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;
}
