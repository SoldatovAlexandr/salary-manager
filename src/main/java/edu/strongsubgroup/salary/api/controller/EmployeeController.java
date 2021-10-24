package edu.strongsubgroup.salary.api.controller;

import edu.strongsubgroup.salary.api.dto.EmployeeDto;
import edu.strongsubgroup.salary.api.mapper.EmployeeMapper;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable("id") Long id) {
        final Employee employee = employeeService.get(id);
        return employeeMapper.to(employee);
    }

    @GetMapping("/")
    public Collection<EmployeeDto> getEmployees() {
        return employeeService.get()
                .stream()
                .map(employeeMapper::to)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeMapper.to(employeeDto);
        employeeService.save(employee);
        return employeeMapper.to(employee);
    }
}
