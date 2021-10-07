package edu.strongsubgroup.salary.service.salary.strategy;

import edu.strongsubgroup.salary.model.Engineer;
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
    }

    @Test
    void calculate_maxRank() {
        Engineer engineer = new Engineer();
        engineer.setElectricalSafetyGrade(10);
        engineer.setInformationSecurityRank(10);
        engineer.setFireSafetyRank(10);
        engineer.setChildrenCount(0);
        engineer.setCoefficient(new BigDecimal(13));

        BigDecimal wage = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("46000"), wage);
    }

    @Test
    void calculate_minRank() {
        Engineer engineer = new Engineer();
        engineer.setElectricalSafetyGrade(0);
        engineer.setInformationSecurityRank(0);
        engineer.setFireSafetyRank(0);
        engineer.setChildrenCount(0);
        engineer.setCoefficient(new BigDecimal(13));

        BigDecimal wage = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("36000"), wage);
    }

    @Test
    void calculate_middleRank() {
        Engineer engineer = new Engineer();
        engineer.setElectricalSafetyGrade(5);
        engineer.setInformationSecurityRank(5);
        engineer.setFireSafetyRank(5);
        engineer.setChildrenCount(0);
        engineer.setCoefficient(new BigDecimal(13));

        BigDecimal wage = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("37250"), wage);
    }
}
