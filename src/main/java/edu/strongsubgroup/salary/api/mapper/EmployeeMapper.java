package edu.strongsubgroup.salary.api.mapper;


import edu.strongsubgroup.salary.api.dto.EmployeeDto;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Engineer;
import edu.strongsubgroup.salary.model.Manager;
import edu.strongsubgroup.salary.model.Worker;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto to(Employee employee) {
        return employee.toDto();
    }

    public Employee to(EmployeeDto employeeDto) {
        return switch (employeeDto.getEmployeeType()) {
            case WORKER -> new Worker(employeeDto);
            case MANAGER -> new Manager(employeeDto);
            case ENGINEER -> new Engineer(employeeDto);
        };
    }
}
