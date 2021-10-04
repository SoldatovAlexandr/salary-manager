package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.model.Engineer;
import edu.asoldatov.salary.model.Salary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AbstractCalculateStrategyTest {

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
    void calculate_withZeroChild() {
        Engineer engineer = new Engineer();
        engineer.setElectricalSafetyGrade(10);
        engineer.setInformationSecurityRank(10);
        engineer.setFireSafetyRank(10);
        engineer.setChildrenCount(0);
        engineer.setCoefficient(new BigDecimal(13));

        Salary salary = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("40020.00"), salary.getAmount());
        assertEquals(new BigDecimal("2346.00"), salary.getMedical());
        assertEquals(new BigDecimal("5980.00"), salary.getNdfl());
        assertEquals(new BigDecimal("0"), salary.getRecoupment());
        assertEquals(new BigDecimal("10120.00"), salary.getRetirement());
        assertEquals(new BigDecimal("1334.00"), salary.getSocial());
        assertEquals(new BigDecimal("46000"), salary.getWage());
        assertNotNull(salary.getCalculationDate());
        assertEquals(engineer, salary.getEmployee());
    }

    @Test
    void calculate_withOneChild() {
        Engineer engineer = new Engineer();
        engineer.setChildrenCount(1);
        engineer.setElectricalSafetyGrade(10);
        engineer.setInformationSecurityRank(10);
        engineer.setFireSafetyRank(10);
        engineer.setCoefficient(new BigDecimal(13));

        Salary salary = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("40202.00"), salary.getAmount());
        assertEquals(new BigDecimal("2346.00"), salary.getMedical());
        assertEquals(new BigDecimal("5798.00"), salary.getNdfl());
        assertEquals(new BigDecimal("1400"), salary.getRecoupment());
        assertEquals(new BigDecimal("10120.00"), salary.getRetirement());
        assertEquals(new BigDecimal("1334.00"), salary.getSocial());
        assertEquals(new BigDecimal("46000"), salary.getWage());
        assertNotNull(salary.getCalculationDate());
        assertEquals(engineer, salary.getEmployee());
    }

    @Test
    void calculate_withTwoChild() {
        Engineer engineer = new Engineer();
        engineer.setChildrenCount(2);
        engineer.setElectricalSafetyGrade(10);
        engineer.setInformationSecurityRank(10);
        engineer.setFireSafetyRank(10);
        engineer.setCoefficient(new BigDecimal(13));

        Salary salary = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("40384.00"), salary.getAmount());
        assertEquals(new BigDecimal("2346.00"), salary.getMedical());
        assertEquals(new BigDecimal("5616.00"), salary.getNdfl());
        assertEquals(new BigDecimal("2800"), salary.getRecoupment());
        assertEquals(new BigDecimal("10120.00"), salary.getRetirement());
        assertEquals(new BigDecimal("1334.00"), salary.getSocial());
        assertEquals(new BigDecimal("46000"), salary.getWage());
        assertNotNull(salary.getCalculationDate());
        assertEquals(engineer, salary.getEmployee());
    }

    @Test
    void calculate_withThreeChild() {
        Engineer engineer = new Engineer();
        engineer.setChildrenCount(3);
        engineer.setElectricalSafetyGrade(10);
        engineer.setInformationSecurityRank(10);
        engineer.setFireSafetyRank(10);
        engineer.setCoefficient(new BigDecimal(13));

        Salary salary = engineerCalculateStrategy.calculate(engineer);

        assertEquals(new BigDecimal("40774.00"), salary.getAmount());
        assertEquals(new BigDecimal("2346.00"), salary.getMedical());
        assertEquals(new BigDecimal("5226.00"), salary.getNdfl());
        assertEquals(new BigDecimal("5800"), salary.getRecoupment());
        assertEquals(new BigDecimal("10120.00"), salary.getRetirement());
        assertEquals(new BigDecimal("1334.00"), salary.getSocial());
        assertEquals(new BigDecimal("46000"), salary.getWage());
        assertNotNull(salary.getCalculationDate());
        assertEquals(engineer, salary.getEmployee());
    }
}
