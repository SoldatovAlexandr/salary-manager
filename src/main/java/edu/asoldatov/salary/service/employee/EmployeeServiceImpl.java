package edu.asoldatov.salary.service.employee;

import edu.asoldatov.salary.exception.NotFoundException;
import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

//TODO: оставил на лучшие времена
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee get(Long id) {
        return employeeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Collection<Employee> get() {
        return employeeRepository.findAll();
    }

}
