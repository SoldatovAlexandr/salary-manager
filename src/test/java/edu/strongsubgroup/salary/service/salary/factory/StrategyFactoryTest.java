package edu.strongsubgroup.salary.service.salary.factory;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.service.salary.strategy.CalculateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.EnumMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StrategyFactoryTest {

    private final EnumMap<EmployeeType, CalculateStrategy> strategyEnumMap = mock(EnumMap.class);
    private final CalculateStrategy calculateStrategy = mock(CalculateStrategy.class);
    private StrategyFactory strategyFactory;

    @BeforeEach
    void setUp() {
        when(strategyEnumMap.get(EmployeeType.ENGINEER)).thenReturn(calculateStrategy);

        strategyFactory = new StrategyFactoryImpl(strategyEnumMap);
    }

    @Test
    void getTest() {
        CalculateStrategy resultStrategy = strategyFactory.get(EmployeeType.ENGINEER);
        verify(strategyEnumMap).get(EmployeeType.ENGINEER);
        assertEquals(calculateStrategy, resultStrategy);
    }
}
