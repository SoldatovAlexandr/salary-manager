package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Worker;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Setter
@Component
public class WorkerCalculateStrategy extends AbstractCalculateStrategy<Worker> {

    @Value("${salary.amount.worker.base}")
    private BigDecimal base;

    @Value("${salary.amount.worker.grade}")
    private BigDecimal grade;

    @Override
    public EmployeeType type() {
        return EmployeeType.WORKER;
    }

    @Override
    protected BigDecimal calculateWage(Worker worker) {
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
