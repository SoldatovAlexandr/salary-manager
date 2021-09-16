package edu.asoldatov.salary.service.vaction;

import edu.asoldatov.salary.common.VacationStatus;
import edu.asoldatov.salary.dto.VacationDto;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Vacation;
import edu.asoldatov.salary.repository.VacationRepository;
import edu.asoldatov.salary.service.employee.EmployeeService;
import edu.asoldatov.salary.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class VacationServiceImpl implements VacationService {

    @Value("${salary.vacation.days}")
    private Long allowedDaysOfVacation;

    private final VacationRepository vacationRepository;
    private final EmployeeService employeeService;

    @Override
    @Transactional
    public Vacation addVacation(VacationDto vacationDto, Employee employee, VacationStatus status) {
        if (vacationDto.getCompensation()) {
            List<Vacation> vacations =
                    vacationRepository.findVacationByYearAndEmployee(employee, DateTimeUtils.getBeginningOfTheYear());
            long countPassedDates = vacations.stream()
                    .map(vacation -> DateTimeUtils.countDay(vacation.getBeginning(), vacation.getEnding()))
                    .reduce(0L, Long::sum);
            long countRequestedDates = DateTimeUtils.countDay(vacationDto.getBeginning(), vacationDto.getEnd());
            if (allowedDaysOfVacation < countPassedDates + countRequestedDates) {
                if (allowedDaysOfVacation + employee.getExtraVacationDays() < countPassedDates + countRequestedDates) {
                    // TODO: 12.09.2021 throw normal Exception
                    throw new RuntimeException();
                } else {
                    employee.setExtraVacationDays(
                            calculateExtraVacationDays(countPassedDates + countRequestedDates));
                    employeeService.save(employee);
                }
            }
        }
        Vacation vacation = Vacation.builder()
                .beginning(vacationDto.getBeginning())
                .ending(vacationDto.getEnd())
                .status(status)
                .compensation(vacationDto.getCompensation())
                .employee(employee)
                .build();
        vacationRepository.save(vacation);
        return vacation;
    }

    @Override
    public Vacation updateStatusVacation(Long vacationId, VacationStatus vacationStatus) {
        Vacation vacation = vacationRepository.getById(vacationId);
        vacation.setStatus(vacationStatus);
        vacationRepository.save(vacation);
        return vacation;
    }

//    @Override
//    public Vacation changeDates(Long vacationId, LocalDate beginning, LocalDate end) {
//        return null;
//    }

    private long calculateExtraVacationDays(long needDays) {
        return Math.abs(allowedDaysOfVacation + needDays);
    }
}
