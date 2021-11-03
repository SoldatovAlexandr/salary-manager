package edu.strongsubgroup.salary.service.salary.strategy;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.configuration.properties.WorkerCalculationsProperties;
import edu.strongsubgroup.salary.model.Worker;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Setter
@Component
public class WorkerCalculateStrategy implements CalculateStrategy<Worker> {

    private final WorkerCalculationsProperties properties;

    private static final long DETAILS_CORRECTION_COEFFICIENT = 100;

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
        return BigDecimal.valueOf(worker.getNumberOfDetails() * DETAILS_CORRECTION_COEFFICIENT);
    }

    private BigDecimal getBaseWage(BigDecimal wageForDetails) {
        return wageForDetails.compareTo(properties.getBase()) > ZERO ? wageForDetails : properties.getBase();
    }

    private BigDecimal calculateAllowance(Worker worker) {
        return properties.getGrade().multiply(worker.getCoefficient()).multiply(worker.getHazardRatio());
    }
}
