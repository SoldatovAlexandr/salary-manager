package edu.strongsubgroup.salary.service.salary;

import edu.strongsubgroup.salary.configuration.SalaryConfig;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Salary;
import edu.strongsubgroup.salary.repository.SalaryRepository;
import edu.strongsubgroup.salary.service.salary.factory.StrategyFactory;
import edu.strongsubgroup.salary.service.salary.strategy.CalculateStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class SalaryServiceImpl implements SalaryService {

    private final StrategyFactory strategyFactory;
    private final SalaryRepository salaryRepository;
    private final SalaryConfig config;

    private static final int FIRST_CHILD_RECOUPMENT = 1400;
    private static final int THIRD_CHILD_RECOUPMENT = 3000;

    @Override
    public Salary calculate(Employee employee) {
        CalculateStrategy calculateStrategy = strategyFactory.get(employee.getEmployeeType());

        BigDecimal wage = calculateStrategy.calculate(employee);

        BigDecimal recoupment = calculateRecoupment(employee.getChildrenCount());
        BigDecimal calculatedNdfl = multiply(wage.subtract(recoupment), config.getNdfl());

        Salary salary = Salary.builder()
                .wage(wage)
                .amount(wage.subtract(calculatedNdfl))
                .recoupment(recoupment)
                .ndfl(calculatedNdfl)
                .medical(multiply(wage, config.getMedical()))
                .social(multiply(wage, config.getSocial()))
                .retirement(multiply(wage, config.getRetirement()))
                .employee(employee)
                .calculationDate(LocalDateTime.now()) // TODO: 12.09.2021 try with LocalDateTime, but could be problems with DB
                .build();
        salaryRepository.save(salary);
        return salary;
    }

    private BigDecimal calculateRecoupment(Integer count) {
        return new BigDecimal(String.valueOf(count < 3 ?
                FIRST_CHILD_RECOUPMENT * count :
                FIRST_CHILD_RECOUPMENT * 2 + (count - 2) * THIRD_CHILD_RECOUPMENT));
    }

    private BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return first.multiply(second)
                .scaleByPowerOfTen(-2)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}
