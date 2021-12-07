package edu.strongsubgroup.salary.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.common.Gender;
import edu.strongsubgroup.salary.common.OverworkingStrategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String firstName;
    private String lastName;
    private String patronymic;
    private EmployeeType employeeType;
    private Gender gender;
    private Integer childrenCount;
    private BigDecimal coefficient;
    private Long extraVacationDays;
    private OverworkingStrategy overworkingStrategy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfEmployment;

    /**
     * Engineer
     */
    private Integer electricalSafetyGrade;
    private Integer fireSafetyRank;
    private Integer informationSecurityRank;

    /**
     * Manager
     */
    private Integer countOfProjects;

    /**
     * Worker
     */
    private Integer numberOfDetails;
    private BigDecimal hazardRatio;
}
