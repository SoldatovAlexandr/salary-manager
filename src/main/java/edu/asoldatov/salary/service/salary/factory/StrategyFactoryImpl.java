package edu.asoldatov.salary.service.salary.factory;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.service.salary.strategy.CalculateStrategy;
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
