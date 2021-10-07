package edu.strongsubgroup.salary.service.salary.factory;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.service.salary.strategy.CalculateStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumMap;

@RequiredArgsConstructor
@Service
public class StrategyFactoryImpl implements StrategyFactory {

    private final EnumMap<EmployeeType, CalculateStrategy> strategyEnumMap;

    @Override
    public CalculateStrategy get(EmployeeType type) {
        return strategyEnumMap.get(type);
    }
}
