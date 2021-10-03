package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.model.Manager;
import edu.asoldatov.salary.model.Salary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerCalculateStrategyTest {

    private ManagerCalculateStrategy managerCalculateStrategy;

    @BeforeEach
    void setUp() {
        managerCalculateStrategy = new ManagerCalculateStrategy();

        managerCalculateStrategy.setBase(new BigDecimal("10000"));
        managerCalculateStrategy.setGrade(new BigDecimal("2000"));
        managerCalculateStrategy.setMedical(new BigDecimal("5.1"));
        managerCalculateStrategy.setNdfl(new BigDecimal("13"));
        managerCalculateStrategy.setRetirement(new BigDecimal("22"));
        managerCalculateStrategy.setSocial(new BigDecimal("2.9"));
    }

    @Test
    void calculate_tenProjects() {
        Manager manager = new Manager();
        manager.setCountOfProjects(10);
        manager.setChildrenCount(0);
        manager.setCoefficient(new BigDecimal(5));

        Salary salary = managerCalculateStrategy.calculate(manager);

        assertEquals(new BigDecimal("100000"), salary.getWage());
    }

    @Test
    void calculate_zeroProjects() {
        Manager manager = new Manager();
        manager.setCountOfProjects(0);
        manager.setChildrenCount(0);
        manager.setCoefficient(new BigDecimal(5));

        Salary salary = managerCalculateStrategy.calculate(manager);

        assertEquals(new BigDecimal("10000"), salary.getWage());
    }

    @Test
    void calculate_oneProjects() {
        Manager manager = new Manager();
        manager.setCountOfProjects(1);
        manager.setChildrenCount(0);
        manager.setCoefficient(new BigDecimal(5));

        Salary salary = managerCalculateStrategy.calculate(manager);

        assertEquals(new BigDecimal("10000"), salary.getWage());
    }
}
