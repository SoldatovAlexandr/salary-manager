package edu.asoldatov.salary.service.salary;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Salary;
import edu.asoldatov.salary.model.Worker;
import edu.asoldatov.salary.repository.SalaryRepository;
import edu.asoldatov.salary.service.salary.factory.StrategyFactory;
import edu.asoldatov.salary.service.salary.strategy.CalculateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SalaryServiceTest {

    private final StrategyFactory strategyFactory = Mockito.mock(StrategyFactory.class);
    private final SalaryRepository salaryRepository = Mockito.mock(SalaryRepository.class);
    private final CalculateStrategy calculateStrategy = Mockito.mock(CalculateStrategy.class);

    private SalaryService salaryService;

    @BeforeEach
    void setUp() {
        salaryService = new SalaryServiceImpl(strategyFactory, salaryRepository);
    }

    @Test
    void calculate() {
        Worker worker = new Worker();
        Salary salary = Salary.builder()
                .amount(BigDecimal.ONE)
                .social(BigDecimal.ZERO)
                .build();

        when(strategyFactory.get(EmployeeType.WORKER)).thenReturn(calculateStrategy);
        when(calculateStrategy.calculate(worker)).thenReturn(salary);

        Salary result = salaryService.calculate(worker);

        verify(calculateStrategy).calculate(worker);
        verify(strategyFactory).get(EmployeeType.WORKER);
        verify(salaryRepository).save(salary);
        assertEquals(salary, result);
    }
}
