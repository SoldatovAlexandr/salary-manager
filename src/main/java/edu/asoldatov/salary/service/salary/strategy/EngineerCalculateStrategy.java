package edu.asoldatov.salary.service.salary.strategy;

import edu.asoldatov.salary.common.EmployeeType;
import edu.asoldatov.salary.model.Engineer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//TODO: add config class for base and grade
@Getter
@Setter
@Component
public class EngineerCalculateStrategy implements CalculateStrategy<Engineer> {

    @Value("${salary.amount.engineer.base}")
    private BigDecimal base;

    @Value("${salary.amount.engineer.grade}")
    private BigDecimal grade;

    private static final long CORRECTION_COEFFICIENT = 10L;

    @Override
    public EmployeeType type() {
        return EmployeeType.ENGINEER;
    }

    @Override
    public BigDecimal calculate(Engineer engineer) {
        return calculateBaseWage(engineer).add(calculateIncreaseForRank(engineer));
    }

    /**
     * Расчитывает базовую зарплату инженера до уплаты налогов.
     * Является дефолтной суммой для всех инженеров.
     */
    private BigDecimal calculateBaseWage(Engineer engineer) {
        return base.add(grade.multiply(engineer.getCoefficient()));
    }

    /**
     * Расчитывает надбавку для каждого конкретного инженера.
     * Надбавка расчитывается на основании квалификаций в областях:
     * электробезопасности, пожарной и информационной безопасности.
     * Ожидаемые значения коэфициентов в пределах от 1 до 10.
     * Максимальная надбавка составляет 10000.
     */
    private BigDecimal calculateIncreaseForRank(Engineer engineer) {
        return BigDecimal.valueOf(engineer.getElectricalSafetyGrade()
                * engineer.getInformationSecurityRank()
                * engineer.getFireSafetyRank()
                * CORRECTION_COEFFICIENT
        );
    }

}
