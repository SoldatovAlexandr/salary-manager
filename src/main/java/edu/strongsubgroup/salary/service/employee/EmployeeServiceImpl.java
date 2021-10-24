package edu.strongsubgroup.salary.service.employee;

import edu.strongsubgroup.salary.exception.NotFoundException;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee get(final Long id) {
        return employeeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Employee save(final Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Collection<Employee> get() {
        return employeeRepository.findAll();
    }
}
