package proof_it.tech_task.core.calculator_actions.fire_case_calculations;

import org.springframework.stereotype.Component;
import proof_it.tech_task.core.domain.Policy;
import proof_it.tech_task.core.domain.PolicyObject;
import proof_it.tech_task.core.domain.PolicySubObject;
import proof_it.tech_task.core.risk_type.RiskType;

@Component
public class SumFireCase {

    //summing all fire cases of the policy
    public Double calculate(Policy policy){
        double sum = 0;
        for (PolicyObject policyObject : policy.getPolicyObject()) {
            for (PolicySubObject policySubObject : policyObject.getPolicySubObjects()) {
                if (policySubObject.getRiskType().equals(RiskType.FIRE)) {
                    sum += policySubObject.getSumInsured();
                }
            }
        }
        return sum;
    }
}
