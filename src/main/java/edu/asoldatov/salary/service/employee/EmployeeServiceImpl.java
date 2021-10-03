package edu.asoldatov.salary.service.employee;

import edu.asoldatov.salary.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Long, Employee> map = Map.of(
    );

    @Override
    public Employee get(Long id) {
        return map.get(id);
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Collection<Employee> get() {
        return map.values();
    }

}
