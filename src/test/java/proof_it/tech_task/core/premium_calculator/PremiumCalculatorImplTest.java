package proof_it.tech_task.core.premium_calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import proof_it.tech_task.core.calculator_actions.fire_case_calculations.PremiumFireCase;
import proof_it.tech_task.core.calculator_actions.theft_case_calculations.PremiumTheftCase;
import proof_it.tech_task.core.domain.Policy;
import proof_it.tech_task.core.domain.PolicyObject;
import proof_it.tech_task.core.domain.PolicySubObject;
import proof_it.tech_task.core.risk_type.RiskType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PremiumCalculatorImplTest {

    @Mock private PremiumFireCase calculatePremiumFireCase;
    @Mock private PremiumTheftCase calculatePremiumTheftCase;
    @InjectMocks private PremiumCalculatorImpl premiumCalculator;

    @Test
    public void CalculateFirstCase(){
        PolicySubObject subObject1 = new PolicySubObject("TV", 100.00, RiskType.FIRE);
        PolicySubObject subObject2 = new PolicySubObject("Fridge", 8.00, RiskType.THEFT);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject1);
        policySubObjects.add(subObject2);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Mockito.when(calculatePremiumFireCase.calculate(policy)).thenReturn(1.4D);
        Mockito.when(calculatePremiumTheftCase.calculate(policy)).thenReturn(0.88D);

        Double result = premiumCalculator.calculate(policy);
        assertEquals(result, 2.28);
    }

    @Test
    public void CalculateSecondCase(){
        PolicySubObject subObject1 = new PolicySubObject("TV", 500.00, RiskType.FIRE);
        PolicySubObject subObject2 = new PolicySubObject("Fridge", 102.51, RiskType.THEFT);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(subObject1);
        policySubObjects.add(subObject2);

        PolicyObject policyObject = new PolicyObject("A House", policySubObjects);

        Policy policy = new Policy("LV20-02-100000-5", "Registered",
                Collections.singletonList(policyObject));

        Mockito.when(calculatePremiumFireCase.calculate(policy)).thenReturn(12D);
        Mockito.when(calculatePremiumTheftCase.calculate(policy)).thenReturn(5.13D);

        Double result = premiumCalculator.calculate(policy);
        assertEquals(result, 17.13);
    }
}