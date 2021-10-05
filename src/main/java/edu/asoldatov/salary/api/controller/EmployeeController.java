package edu.asoldatov.salary.api.controller;

import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeService.get(id);
    }

    @GetMapping("/")
    public Collection<Employee> getEmployees() {
        return employeeService.get();
    }

    @PostMapping("/")
    public String addEmployee() {
        return "employee";
    }

    @PutMapping("/")
    public String updateEmployee() {
        return "employee";
    }
}
