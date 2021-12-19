package edu.strongsubgroup.salary.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import edu.strongsubgroup.salary.common.EmployeeStatus;
import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.common.Gender;
import edu.strongsubgroup.salary.common.OverworkingStrategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    /**
     * Common fields
     */
    private Long id;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я]*$", message = "incorrect.first.name.error")
    @NotBlank(message = "required.first.name.error")
    @Size(max = 64, message = "long.first.name.error")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я]*$", message = "incorrect.last.name.error")
    @NotBlank(message = "required.last.name.error")
    @Size(max = 64, message = "long.last.name.error")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я]*$", message = "incorrect.patronymic.error")
    @NotBlank(message = "required.patronymic.error")
    @Size(max = 64, message = "long.patronymic.error")
    private String patronymic;

    @NotNull(message = "required.employee.type.error")
    private EmployeeType employeeType;

    @NotNull(message = "required.gender.error")
    private Gender gender;

    @Min(value = 0, message = "incorrect.children.count")
    @Max(value = 50, message = "long.children.count")
    private Integer childrenCount;

    @Min(value = 0, message = "incorrect.coefficient")
    @Max(value = 10, message = "long.coefficient")
    @NotNull(message = "required.coefficient")
    private BigDecimal coefficient;

    @Min(value = 0, message = "incorrect.extra.vacation.days")
    @Max(value = 30, message = "long.extra.vacation.days")
    @NotNull(message = "required.extra.vacation.days")
    private Long extraVacationDays;

    @NotNull(message = "required.overworking.strategy")
    private OverworkingStrategy overworkingStrategy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfEmployment;

    private EmployeeStatus employeeStatus;

    /**
     * Engineer
     */

    @Min(value = 0, message = "incorrect.electrical.safety.grade")
    @Max(value = 10, message = "long.electrical.safety.grade")
    private Integer electricalSafetyGrade;

    @Min(value = 0, message = "incorrect.fire.safety.rank")
    @Max(value = 10, message = "long.fire.safety.rank")
    private Integer fireSafetyRank;

    @Min(value = 0, message = "incorrect.information.security.rank")
    @Max(value = 10, message = "long.information.security.rank")
    private Integer informationSecurityRank;

    /**
     * Manager
     */
    @Min(value = 0, message = "incorrect.count.of.projects")
    @Max(value = 10, message = "long.count.of.projects")
    private Integer countOfProjects;

    /**
     * Worker
     */
    @Min(value = 0, message = "incorrect.number.of.details")
    @Max(value = 10000, message = "long.number.of.details")
    private Integer numberOfDetails;

    @Min(value = 0, message = "incorrect.hazard.ratio")
    @Max(value = 10, message = "long.hazard.ratio")
    private BigDecimal hazardRatio;
}
