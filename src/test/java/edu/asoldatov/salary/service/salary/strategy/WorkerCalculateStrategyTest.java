package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.model.Salary;
import edu.asoldatov.salary.model.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkerCalculateStrategyTest {

    private WorkerCalculateStrategy workerCalculateStrategy;

    @BeforeEach
    void setUp() {
        workerCalculateStrategy = new WorkerCalculateStrategy();

        workerCalculateStrategy.setBase(new BigDecimal("10000"));
        workerCalculateStrategy.setGrade(new BigDecimal("2000"));
        workerCalculateStrategy.setMedical(new BigDecimal("5.1"));
        workerCalculateStrategy.setNdfl(new BigDecimal("13"));
        workerCalculateStrategy.setRetirement(new BigDecimal("22"));
        workerCalculateStrategy.setSocial(new BigDecimal("2.9"));
    }

    @Test
    void calculate() {
        Worker worker = new Worker();
        worker.setNumberOfDetails(200);
        worker.setHazardRatio(new BigDecimal("2"));
        worker.setChildrenCount(0);
        worker.setCoefficient(new BigDecimal(5));

        Salary salary = workerCalculateStrategy.calculate(worker);

        assertEquals(new BigDecimal("40000"), salary.getWage());
    }

    @Test
    void calculate_baseWage() {
        Worker worker = new Worker();
        worker.setNumberOfDetails(0);
        worker.setHazardRatio(new BigDecimal("2"));
        worker.setChildrenCount(0);
        worker.setCoefficient(new BigDecimal(5));

        Salary salary = workerCalculateStrategy.calculate(worker);

        assertEquals(new BigDecimal("30000"), salary.getWage());
    }
}
