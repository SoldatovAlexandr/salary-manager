package edu.strongsubgroup.salary.service.salary.strategy;

import edu.strongsubgroup.salary.model.Worker;
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
    }

    @Test
    void calculate() {
        Worker worker = new Worker();
        worker.setNumberOfDetails(200);
        worker.setHazardRatio(new BigDecimal("2"));
        worker.setChildrenCount(0);
        worker.setCoefficient(new BigDecimal(5));

        BigDecimal wage = workerCalculateStrategy.calculate(worker);

        assertEquals(new BigDecimal("40000"), wage);
    }

    @Test
    void calculate_baseWage() {
        Worker worker = new Worker();
        worker.setNumberOfDetails(0);
        worker.setHazardRatio(new BigDecimal("2"));
        worker.setChildrenCount(0);
        worker.setCoefficient(new BigDecimal(5));

        BigDecimal wage = workerCalculateStrategy.calculate(worker);

        assertEquals(new BigDecimal("30000"), wage);
    }
}
