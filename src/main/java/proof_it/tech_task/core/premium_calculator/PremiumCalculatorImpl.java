package proof_it.tech_task.core.premium_calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proof_it.tech_task.core.calculator_actions.Case;
import proof_it.tech_task.core.calculator_actions.fire_case_calculations.PremiumFireCase;
import proof_it.tech_task.core.calculator_actions.theft_case_calculations.PremiumTheftCase;
import proof_it.tech_task.core.domain.Policy;

@Component
public class PremiumCalculatorImpl implements PremiumCalculator {

    @Autowired private PremiumFireCase calculatePremiumFireCase;
    @Autowired private PremiumTheftCase calculatePremiumTheftCase;

    //summing all insurance cases
    @Override
    public Double calculate(Policy policy) {
        Double sum = 0D;
        Case[] calculateMethods = getPremiums();
        for (Case insuranceCase : calculateMethods){
            sum += insuranceCase.calculate(policy);
        }
        return sum;
    }

    //get premium cases
    private Case[] getPremiums(){
        return new Case[]{
                calculatePremiumFireCase,
                calculatePremiumTheftCase};
    }
}
