package edu.strongsubgroup.salary.service.employee;

import edu.strongsubgroup.salary.exception.NotFoundException;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.repository.EmployeeRepository;
import edu.strongsubgroup.salary.repository.specification.EmployeeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findById(final Long id) {
        return employeeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void save(final Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findBySpecification(EmployeeSpecification specification, Pageable pageable) {
        return employeeRepository.findAll(specification, pageable);
    }

    @Override
    public Collection<Employee> findUnCalculated(Long limit) {
        return employeeRepository.findUnCalculated(limit);
    }

}
