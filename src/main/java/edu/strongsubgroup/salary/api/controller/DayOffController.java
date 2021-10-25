package edu.strongsubgroup.salary.api.controller;

import edu.strongsubgroup.salary.api.dto.DayOffDto;
import edu.strongsubgroup.salary.common.DayOffStatus;
import edu.strongsubgroup.salary.model.DayOff;
import edu.strongsubgroup.salary.model.Worker;
import edu.strongsubgroup.salary.service.day.off.DayOffService;
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
