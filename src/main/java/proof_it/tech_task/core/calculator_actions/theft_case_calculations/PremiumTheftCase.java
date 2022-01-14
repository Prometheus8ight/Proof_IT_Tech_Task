package proof_it.tech_task.core.calculator_actions.theft_case_calculations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proof_it.tech_task.core.calculator_actions.Case;
import proof_it.tech_task.core.domain.Policy;

@Component
public class PremiumTheftCase implements Case {

    @Autowired private SumTheftCase sumTheftCase;

    private final double THEFT_COEFFICIENT_FOR_SUM_HIGHER_OR_EQUAL_15 = 0.05;
    private final double THEFT_COEFFICIENT_FOR_SUM_UNDER_15 = 0.11;

    //multiply sum on theft coefficient + round premium
    public Double calculate(Policy policy) {
        Double sum = sumTheftCase.calculate(policy);
        if (sum >= 15.0) {
            return Math.round((sum * THEFT_COEFFICIENT_FOR_SUM_HIGHER_OR_EQUAL_15) * 100.0) / 100.0;
        } else {
            return Math.round((sum * THEFT_COEFFICIENT_FOR_SUM_UNDER_15) * 100.0) / 100.0;
        }
    }
}
