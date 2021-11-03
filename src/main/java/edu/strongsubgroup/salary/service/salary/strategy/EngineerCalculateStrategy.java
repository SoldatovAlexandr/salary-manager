package edu.strongsubgroup.salary.service.salary.strategy;

import edu.strongsubgroup.salary.common.EmployeeType;
import edu.strongsubgroup.salary.configuration.properties.EngineerCalculationsProperties;
import edu.strongsubgroup.salary.model.Engineer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@Setter
@Component
public class EngineerCalculateStrategy implements CalculateStrategy<Engineer> {

    private final EngineerCalculationsProperties properties;

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
        return properties.getBase().add(properties.getGrade().multiply(engineer.getCoefficient()));
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
