package edu.strongsubgroup.salary.service.salary.strategy;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.model.Worker;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Setter
@Component
public class WorkerCalculateStrategy implements CalculateStrategy<Worker> {

    @Value("${salary.amount.worker.base}")
    private BigDecimal base;

    @Value("${salary.amount.worker.grade}")
    private BigDecimal grade;

    @Override
    public EmployeeType type() {
        return EmployeeType.WORKER;
    }

    @Override
    public BigDecimal calculate(Worker worker) {
        BigDecimal wageForDetails = calculateWageForDetails(worker);
        return getBaseWage(wageForDetails).add(calculateAllowance(worker));
    }

    private BigDecimal calculateWageForDetails(Worker worker) {
        return BigDecimal.valueOf(worker.getNumberOfDetails() * 100);
    }

    private BigDecimal getBaseWage(BigDecimal wageForDetails) {
        return wageForDetails.compareTo(base) > ZERO ? wageForDetails : base;
    }

    private BigDecimal calculateAllowance(Worker worker) {
        return grade.multiply(worker.getCoefficient()).multiply(worker.getHazardRatio());
    }
}
