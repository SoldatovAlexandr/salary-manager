package edu.strongsubgroup.salary.service.salary;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.configuration.properties.SalaryTaxProperties;
import edu.strongsubgroup.salary.model.Salary;
import edu.strongsubgroup.salary.model.Worker;
import edu.strongsubgroup.salary.repository.SalaryRepository;
import edu.strongsubgroup.salary.service.salary.factory.StrategyFactory;
import edu.strongsubgroup.salary.service.salary.strategy.CalculateStrategy;
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

    private final SalaryTaxProperties config = SalaryTaxProperties.builder()
            .retirement(new BigDecimal("22"))
            .medical(new BigDecimal("5.1"))
            .ndfl(new BigDecimal("13"))
            .social(new BigDecimal("2.9"))
            .build();

    @BeforeEach
    void setUp() {
        when(strategyFactory.get(EmployeeType.WORKER)).thenReturn(calculateStrategy);

        salaryService = new SalaryServiceImpl(strategyFactory, salaryRepository, config);
    }

    @Test
    void calculate_zeroChild() {
        Worker worker = new Worker();
        worker.setChildrenCount(0);

        when(calculateStrategy.calculate(worker)).thenReturn(new BigDecimal("10000"));

        Salary result = salaryService.calculate(worker);

        verify(calculateStrategy).calculate(worker);
        verify(strategyFactory).get(EmployeeType.WORKER);
        assertEquals(new BigDecimal("8700.00"), result.getAmount());
        assertEquals(new BigDecimal("10000"), result.getWage());
        assertEquals(new BigDecimal("2200.00"), result.getRetirement());
        assertEquals(new BigDecimal("290.00"), result.getSocial());
        assertEquals(new BigDecimal("1300.00"), result.getNdfl());
        assertEquals(new BigDecimal("510.00"), result.getMedical());
    }

    @Test
    void calculate_oneChild() {
        Worker worker = new Worker();
        worker.setChildrenCount(1);

        when(calculateStrategy.calculate(worker)).thenReturn(new BigDecimal("10000"));

        Salary result = salaryService.calculate(worker);

        verify(calculateStrategy).calculate(worker);
        verify(strategyFactory).get(EmployeeType.WORKER);
        assertEquals(new BigDecimal("8882.00"), result.getAmount());
        assertEquals(new BigDecimal("10000"), result.getWage());
        assertEquals(new BigDecimal("2200.00"), result.getRetirement());
        assertEquals(new BigDecimal("290.00"), result.getSocial());
        assertEquals(new BigDecimal("1118.00"), result.getNdfl());
        assertEquals(new BigDecimal("510.00"), result.getMedical());
    }

    @Test
    void calculate_twoChild() {
        Worker worker = new Worker();
        worker.setChildrenCount(2);

        when(calculateStrategy.calculate(worker)).thenReturn(new BigDecimal("10000"));

        Salary result = salaryService.calculate(worker);

        verify(calculateStrategy).calculate(worker);
        verify(strategyFactory).get(EmployeeType.WORKER);
        assertEquals(new BigDecimal("9064.00"), result.getAmount());
        assertEquals(new BigDecimal("10000"), result.getWage());
        assertEquals(new BigDecimal("2200.00"), result.getRetirement());
        assertEquals(new BigDecimal("290.00"), result.getSocial());
        assertEquals(new BigDecimal("936.00"), result.getNdfl());
        assertEquals(new BigDecimal("510.00"), result.getMedical());
    }

    @Test
    void calculate_threeChild() {
        Worker worker = new Worker();
        worker.setChildrenCount(3);

        when(calculateStrategy.calculate(worker)).thenReturn(new BigDecimal("10000"));

        Salary result = salaryService.calculate(worker);

        verify(calculateStrategy).calculate(worker);
        verify(strategyFactory).get(EmployeeType.WORKER);
        assertEquals(new BigDecimal("9454.00"), result.getAmount());
        assertEquals(new BigDecimal("10000"), result.getWage());
        assertEquals(new BigDecimal("2200.00"), result.getRetirement());
        assertEquals(new BigDecimal("290.00"), result.getSocial());
        assertEquals(new BigDecimal("546.00"), result.getNdfl());
        assertEquals(new BigDecimal("510.00"), result.getMedical());
    }

    @Test
    void calculate_fourChild() {
        Worker worker = new Worker();
        worker.setChildrenCount(4);

        when(calculateStrategy.calculate(worker)).thenReturn(new BigDecimal("10000"));

        Salary result = salaryService.calculate(worker);

        verify(calculateStrategy).calculate(worker);
        verify(strategyFactory).get(EmployeeType.WORKER);
        assertEquals(new BigDecimal("9844.00"), result.getAmount());
        assertEquals(new BigDecimal("10000"), result.getWage());
        assertEquals(new BigDecimal("2200.00"), result.getRetirement());
        assertEquals(new BigDecimal("290.00"), result.getSocial());
        assertEquals(new BigDecimal("156.00"), result.getNdfl());
        assertEquals(new BigDecimal("510.00"), result.getMedical());
    }
}
