package edu.strongsubgroup.salary.service.salary.factory;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.service.salary.strategy.CalculateStrategy;

public interface StrategyFactory {
    CalculateStrategy get(EmployeeType employeeType);
}
