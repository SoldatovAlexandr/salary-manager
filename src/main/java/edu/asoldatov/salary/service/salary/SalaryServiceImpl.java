package edu.asoldatov.salary.service.salary;

import edu.asoldatov.salary.model.Employee;
import edu.asoldatov.salary.model.Salary;
import edu.asoldatov.salary.repository.SalaryRepository;
import edu.asoldatov.salary.service.salary.factory.StrategyFactory;
import edu.asoldatov.salary.service.salary.strategy.CalculateStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SalaryServiceImpl implements SalaryService {

    private final StrategyFactory strategyFactory;
    private final SalaryRepository salaryRepository;

    @Override
    public Salary calculate(Employee employee) {
        CalculateStrategy calculateStrategy = strategyFactory.get(employee.getType());
        Salary salary = calculateStrategy.calculate(employee);
        salaryRepository.save(salary);
        return salary;
    }
}
