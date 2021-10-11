package edu.asoldatov.salary.controller;

import edu.asoldatov.salary.common.DayOffStatus;
import edu.asoldatov.salary.common.VacationStatus;
import edu.asoldatov.salary.dto.DayOffDto;
import edu.asoldatov.salary.dto.VacationDto;
import edu.asoldatov.salary.model.DayOff;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Vacation;
import edu.asoldatov.salary.model.Worker;
import edu.asoldatov.salary.service.day.off.DayOffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/dayOff")
public class DayOffController {

    private final DayOffService dayOffService;

    /**
     * Employee requests day off
     * @param dayOffDto
     * @return
     */
    @PostMapping("/")
    public DayOff requestDayOff(@RequestBody DayOffDto dayOffDto) {
        // TODO: 12.09.2021 get Employee from user
        return dayOffService.requestDayOff(dayOffDto, new Worker());
    }

    @PutMapping("/{dayOffId}")
    public DayOff updateDayOffStatus(@PathVariable (value = "dayOffId") Long dayOffId,
                                     @RequestParam (value = "dayOffStatus") DayOffStatus status) {
        return dayOffService.updateStatus(dayOffId, status);
    }
}
