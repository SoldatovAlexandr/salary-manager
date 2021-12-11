package edu.strongsubgroup.salary.service.salary;

import edu.strongsubgroup.salary.configuration.properties.SalaryTaxProperties;
import edu.strongsubgroup.salary.model.Employee;
import edu.strongsubgroup.salary.model.Salary;
import edu.strongsubgroup.salary.repository.SalaryRepository;
import edu.strongsubgroup.salary.service.salary.factory.StrategyFactory;
import edu.strongsubgroup.salary.service.salary.strategy.CalculateStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class SalaryServiceImpl implements SalaryService {

    private final StrategyFactory strategyFactory;
    private final SalaryRepository salaryRepository;
    private final SalaryTaxProperties properties;

    private static final int FIRST_CHILD_RECOUPMENT = 1400;
    private static final int THIRD_CHILD_RECOUPMENT = 3000;

    @Override
    public Salary calculate(Employee employee) {
        CalculateStrategy calculateStrategy = strategyFactory.get(employee.getEmployeeType());

        BigDecimal wage = calculateStrategy.calculate(employee);

        BigDecimal recoupment = calculateRecoupment(employee.getChildrenCount());
        BigDecimal calculatedNdfl = multiply(wage.subtract(recoupment), properties.getNdfl());

        Salary salary = Salary.builder()
                .wage(wage)
                .amount(wage.subtract(calculatedNdfl))
                .recoupment(recoupment)
                .ndfl(calculatedNdfl)
                .medical(multiply(wage, properties.getMedical()))
                .social(multiply(wage, properties.getSocial()))
                .retirement(multiply(wage, properties.getRetirement()))
                .employee(employee)
                .calculationDate(LocalDateTime.now()) // TODO: 12.09.2021 try with LocalDateTime, but could be problems with DB
                .build();
        return salary;
    }

    @Override
    public void save(Salary salary) {
        salaryRepository.save(salary);
    }

    @Override
    public Page<Salary> findAllByEmployee(Employee employee, Pageable pageable) {
        return salaryRepository.findAllByEmployee(employee, pageable);
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
