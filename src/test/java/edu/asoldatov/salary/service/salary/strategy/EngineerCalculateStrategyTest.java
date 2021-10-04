package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.model.Engineer;
import edu.asoldatov.salary.model.Salary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineerCalculateStrategyTest {

    private EngineerCalculateStrategy engineerCalculateStrategy;

    @BeforeEach
    void setUp() {
        engineerCalculateStrategy = new EngineerCalculateStrategy();

        engineerCalculateStrategy.setBase(new BigDecimal("10000"));
        engineerCalculateStrategy.setGrade(new BigDecimal("2000"));
        engineerCalculateStrategy.setMedical(new BigDecimal("5.1"));
        engineerCalculateStrategy.setNdfl(new BigDecimal("13"));
        engineerCalculateStrategy.setRetirement(new BigDecimal("22"));
        engineerCalculateStrategy.setSocial(new BigDecimal("2.9"));
    }

    @Test
    void calculate_maxRank() {
        Engineer engineer = new Engineer();
        engineer.setElectricalSafetyGrade(10);
        engineer.setInformationSecurityRank(10);
        engineer.setFireSafetyRank(10);
        engineer.setChildrenCount(0);
        engineer.setCoefficient(new BigDecimal(13));

        Salary salary = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("46000"), salary.getWage());
    }

    @Test
    void calculate_minRank() {
        Engineer engineer = new Engineer();
        engineer.setElectricalSafetyGrade(0);
        engineer.setInformationSecurityRank(0);
        engineer.setFireSafetyRank(0);
        engineer.setChildrenCount(0);
        engineer.setCoefficient(new BigDecimal(13));

        Salary salary = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("36000"), salary.getWage());
    }

    @Test
    void calculate_middleRank() {
        Engineer engineer = new Engineer();
        engineer.setElectricalSafetyGrade(5);
        engineer.setInformationSecurityRank(5);
        engineer.setFireSafetyRank(5);
        engineer.setChildrenCount(0);
        engineer.setCoefficient(new BigDecimal(13));

        Salary salary = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("37250"), salary.getWage());
    }
}
