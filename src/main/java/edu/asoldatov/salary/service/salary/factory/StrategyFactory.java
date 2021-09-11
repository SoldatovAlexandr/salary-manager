package edu.asoldatov.salary.service.salary.factory;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.service.salary.strategy.CalculateStrategy;

public interface StrategyFactory {
    CalculateStrategy get(EmployeeType employeeType);
}
