package edu.strongsubgroup.salary.api.controller;

import edu.strongsubgroup.salary.api.dto.SalaryDto;
import edu.strongsubgroup.salary.api.mapper.SalaryMapper;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Salary;
import edu.strongsubgroup.salary.service.employee.EmployeeService;
import edu.strongsubgroup.salary.service.salary.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees/{employeeId}/salaries")
public class SalaryController {

    private final SalaryService salaryService;
    private final EmployeeService employeeService;
    private final SalaryMapper salaryMapper;

    @GetMapping("/calculate")
    public SalaryDto calculate(@PathVariable("employeeId") Long employeeId) {
        Employee employee = employeeService.findById(employeeId);
        Salary salary = salaryService.calculate(employee);
        return salaryMapper.to(salary);
    }

    @Transactional
    @GetMapping("/")
    public Page<SalaryDto> getSalaries(@PathVariable("employeeId") Long employeeId,
                                       @PageableDefault(sort = {"calculationDate"}, direction = Sort.Direction.DESC, size = 20) final Pageable pageable) {
        Employee employee = employeeService.findById(employeeId);
        Page<Salary> salaries = salaryService.findAllByEmployee(employee, pageable);
        return salaries.map(salaryMapper::to);
    }
}
