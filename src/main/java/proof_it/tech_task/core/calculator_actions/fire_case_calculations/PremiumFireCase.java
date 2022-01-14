package proof_it.tech_task.core.calculator_actions.fire_case_calculations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proof_it.tech_task.core.calculator_actions.Case;
import proof_it.tech_task.core.domain.Policy;

@Component
public class PremiumFireCase implements Case {

    @Autowired private SumFireCase sumFireCase;

    private final double FIRE_COEFFICIENT_FOR_SUM_MORE_THAN_100 = 0.024;
    private final double FIRE_COEFFICIENT_FOR_SUM_LESS_OR_EQUAL_100 = 0.014;

    //multiply sum on fire coefficient + round premium
    public Double calculate(Policy policy) {
        Double sum = sumFireCase.calculate(policy);
        if (sum > 100.0) {
            return Math.round((sum * FIRE_COEFFICIENT_FOR_SUM_MORE_THAN_100) * 100.0) / 100.0;
        } else {
            return Math.round((sum * FIRE_COEFFICIENT_FOR_SUM_LESS_OR_EQUAL_100) * 100.0) / 100.0;
        }
    }
}
