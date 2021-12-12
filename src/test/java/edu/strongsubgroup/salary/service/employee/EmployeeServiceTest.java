package edu.strongsubgroup.salary.service.employee;

import edu.strongsubgroup.salary.exception.NotFoundException;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.repository.EmployeeRepository;
import edu.strongsubgroup.salary.repository.specification.EmployeeSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    private final EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    void findById() {
        Employee employee = mock(Employee.class);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee result = employeeService.findById(1L);

        verify(employeeRepository).findById(1L);
        assertEquals(employee, result);
    }

    @Test
    void findById_notFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> employeeService.findById(1L));
    }

    @Test
    void save() {
        Employee employee = mock(Employee.class);

        employeeService.save(employee);

        verify(employeeRepository).save(employee);
    }

    @Test
    void findBySpecification() {
        EmployeeSpecification specification = mock(EmployeeSpecification.class);
        Pageable pageable = mock(Pageable.class);
        Page<Employee> employees = mock(Page.class);
        when(employeeRepository.findAll(specification, pageable)).thenReturn(employees);

        Page<Employee> result = employeeService.findBySpecification(specification, pageable);

        verify(employeeRepository).findAll(specification, pageable);
        assertEquals(employees, result);
    }

    @Test
    void findUnCalculated() {
        when(employeeRepository.findUnCalculated(10L)).thenReturn(List.of());

        Collection<Employee> result = employeeService.findUnCalculated(10L);

        verify(employeeRepository).findUnCalculated(10L);
        assertEquals(List.of(), result);
    }
}
