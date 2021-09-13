package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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
        return base.add(grade.multiply(worker.getCoefficient()));
    }
}
