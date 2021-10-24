package edu.strongsubgroup.salary.api.controller;

import edu.strongsubgroup.salary.api.dto.SalaryDto;
import edu.strongsubgroup.salary.api.mapper.SalaryMapper;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Salary;
import edu.strongsubgroup.salary.service.employee.EmployeeService;
import edu.strongsubgroup.salary.service.salary.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees/salaries")
public class SalaryController {

    private final SalaryService salaryService;
    private final EmployeeService employeeService;
    private final SalaryMapper salaryMapper;

    @GetMapping("/{id}")
    public SalaryDto calculate(@PathVariable("id") Long id) {
        Employee employee = employeeService.get(id);
        Salary salary = salaryService.calculate(employee);
        return salaryMapper.to(salary);
    }

    @GetMapping("/")
    public List<SalaryDto> calculate() {
        return employeeService.get()
                .stream()
                .map(salaryService::calculate)
                .map(salaryMapper::to)
                .collect(Collectors.toList());
    }
}
