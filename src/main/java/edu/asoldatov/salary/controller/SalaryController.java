package edu.asoldatov.salary.controller;

import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;
import edu.asoldatov.salary.service.employee.EmployeeService;
import edu.asoldatov.salary.service.salary.SalaryService;
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

    @GetMapping("/{id}")
    public Salary calculate(@PathVariable("id") Long id) {
        Employee employee = employeeService.get(id);
        return salaryService.calculate(employee);
    }

    @GetMapping("/")
    public List<Salary> calculate() {
        return employeeService.get()
                .stream()
                .map(salaryService::calculate)
                .collect(Collectors.toList());
    }
}
