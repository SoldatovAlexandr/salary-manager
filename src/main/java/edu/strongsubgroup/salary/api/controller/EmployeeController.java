package edu.strongsubgroup.salary.api.controller;

import edu.strongsubgroup.salary.api.dto.EmployeeDto;
import edu.strongsubgroup.salary.api.mapper.EmployeeMapper;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.repository.specification.EmployeeSpecification;
import edu.strongsubgroup.salary.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable("id") Long id) {
        final Employee employee = employeeService.findById(id);
        return employeeMapper.to(employee);
    }

    @GetMapping("/")
    public Page<EmployeeDto> getEmployees(final EmployeeSpecification specification,
                                          @PageableDefault(sort = {"firstName"}, direction = Sort.Direction.DESC, size = 20) final Pageable pageable) {
        Page<Employee> employees = employeeService.findBySpecification(specification, pageable);
        return employees.map(employeeMapper::to);
    }

    @PostMapping("/")
    public EmployeeDto addEmployee(@Validated @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeMapper.to(employeeDto);
        employeeService.save(employee);
        return employeeMapper.to(employee);
    }

    @DeleteMapping("/{id}")
    public EmployeeDto fireEmployee(@PathVariable("id") Long id){
        final Employee employee = employeeService.fire(id);
        return employeeMapper.to(employee);
    }
}
