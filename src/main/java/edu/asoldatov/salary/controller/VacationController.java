package edu.asoldatov.salary.controller;

import edu.asoldatov.salary.common.VacationStatus;
import edu.asoldatov.salary.dto.VacationDto;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Vacation;
import edu.asoldatov.salary.model.Worker;
import edu.asoldatov.salary.service.employee.EmployeeService;
import edu.asoldatov.salary.service.vacation.VacationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/vacation")
public class VacationController {

    private final VacationService vacationService;
    private final EmployeeService employeeService;

    /**
     * Employee requests vacation
     * @param vacationDto
     * @return
     */
    @PostMapping("/")
    public Vacation requestVacation(@RequestBody VacationDto vacationDto) {
        // TODO: 12.09.2021 get Employee from user
        return vacationService.addVacation(vacationDto, new Worker(), VacationStatus.REQUESTED);
    }

    /**
     * Manager gives vacation for Employee
     * @param vacationDto
     * @param employeeId
     * @return
     */
    @PostMapping("/{employeeId}")
    public Vacation addVacation(@RequestBody VacationDto vacationDto,
                                @PathVariable(name = "employeeId") Long employeeId) {
        Employee employee = employeeService.get(employeeId);
        return vacationService.addVacation(vacationDto, employee, VacationStatus.ALLOWED);
    }

    @PutMapping("/{vacationId}/{status}")
    public Vacation changeStatus(@PathVariable(name = "vacationId") Long id,
                                 @PathVariable(name = "status") VacationStatus status) {
        return vacationService.updateStatusVacation(id, status);
    }

    @PutMapping("/{vacationId}")
    public Vacation changeDates(@PathVariable(name = "vacationId") Long id,
                                @RequestBody VacationDto vacationDto) {
        // TODO: 16.09.2021 check who updates
        return vacationService.changeDates(id, vacationDto.getBeginning(),
                vacationDto.getBeginning(), VacationStatus.REQUESTED);
    }
}
