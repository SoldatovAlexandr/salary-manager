package edu.strongsubgroup.salary.repository.specification;

import edu.strongsubgroup.salary.model.Employee;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "firstName", spec = Like.class),
        @Spec(path = "lastName", spec = Like.class),
        @Spec(path = "patronymic", spec = Like.class),
        @Spec(path = "type", spec = Equal.class),
})
public interface EmployeeSpecification extends Specification<Employee> {
}
