package edu.asoldatov.salary.service.employee;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Long, Employee> map = Map.of(
            1L, Employee.builder().id(1L).type(EmployeeType.ENGINEER).build(),
            2L, Employee.builder().id(2L).type(EmployeeType.ENGINEER).build(),
            3L, Employee.builder().id(3L).type(EmployeeType.MANAGER).build(),
            4L, Employee.builder().id(4L).type(EmployeeType.WORKER).build(),
            5L, Employee.builder().id(5L).type(EmployeeType.WORKER).build(),
            6L, Employee.builder().id(6L).type(EmployeeType.WORKER).build()
    );

    @Override
    public Employee get(Long id) {
        return map.get(id);
    }

    @Override
    public Collection<Employee> get() {
        return map.values();
    }

}
